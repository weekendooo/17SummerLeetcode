package Trie;

import java.util.ArrayList;
import java.util.List;

public class No212WordSearch2 {

private static final int[][] dirs = { {0,1}, {1,0}, {-1,0}, {0,-1} };
    
    public List<String> findWords(char[][] board, String[] words) {
        int m = board.length;
        int n = board[0].length;
        List<String> res = new ArrayList<>();
        TrieNode root = buildTrie(words);
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                findWords(board, i, j, root, res);
            }
        }
        return res;
    }
    
    private void findWords(char[][] board, int x, int y, TrieNode p, List<String> res) {
        if (x < 0 || y < 0 || x == board.length || y == board[0].length) return;
        char c = board[x][y];
        if (c == '#' || p.next[c - 'a'] == null) return;
        p = p.next[c - 'a'];
        if (p.word != null) {
            res.add(p.word);
            p.word = null; // ? de-depulicate
        }
        
        board[x][y] = '#';
        for (int[] dir : dirs) {
            findWords(board, x + dir[0], y + dir[1], p, res);
        }
        board[x][y] = c;
    }
    
    class TrieNode {
        String word;
        TrieNode[] next = new TrieNode[26];
    }
    
    public TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String w : words) {
            TrieNode p = root;
            for (char c : w.toCharArray()) {
                int i = c - 'a';
                if (p.next[i] == null) p.next[i] = new TrieNode();
                p = p.next[i];
            }
            p.word = w;
        }
        return root;
    }
	
	public static void main(String[] args) {
		String s = "bat";
		System.out.println(s.substring(0));
	}

}
