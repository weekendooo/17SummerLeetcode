package Trie;

public class No211AddandSearchWordDatastructuredesign {

	class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String item;
    }
    private TrieNode root = new TrieNode();
    
    /** Initialize your data structure here. */
    public No211AddandSearchWordDatastructuredesign() {
        
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
        }
        node.item = word; 
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return match(word.toCharArray(), 0, root);
    }
    
    private boolean match(char[] ch, int index, TrieNode node) {
        if (index == ch.length) return node.item != null;
        if (ch[index] != '.') {
            return node.children[ch[index] - 'a'] != null && match(ch, index + 1, node.children[ch[index] - 'a']);
        }
        else {
            for (int i = 0; i < node.children.length; i++) {  // 如果是'.'的话，每种子树都要试一下
                if (node.children[i] != null) {
                    if (match(ch, index + 1, node.children[i])) 
                        return true; 
                }
            }
        }
        return false;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
