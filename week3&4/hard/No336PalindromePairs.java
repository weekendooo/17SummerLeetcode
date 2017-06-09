package Trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class No336PalindromePairs {

	public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        if (words == null || words.length <= 1) return res;
        
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }
        
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j <= words[i].length(); j++) {
                String str1 = words[i].substring(0, j);
                String str2 = words[i].substring(j);
                
                if (isPalindrome(str1)) {
                    String str2Reverse = new StringBuilder(str2).reverse().toString();
                    // if (map.containsKey(str2Reverse) && map.get(str2Reverse) != i) 
                    Integer index = map.get(str2Reverse);
                    if (index != null && index != i) {
                        List<Integer> list = new ArrayList<Integer>();
                        list.add(map.get(str2Reverse));
                        list.add(i);
                        res.add(list);
                    }
                }
                
                if (isPalindrome(str2)) {
                    String str1Reverse = new StringBuilder(str1).reverse().toString();
                    // if (map.containsKey(str1Reverse) && map.get(str1Reverse) != i && str2.length()!=0) 
                    Integer index = map.get(str1Reverse); 
                    if (index != null && index != i && str2.length()!=0) {
                        List<Integer> list = new ArrayList<Integer>();
                        list.add(i);
                        list.add(map.get(str1Reverse));
                        res.add(list);
                    }
                }
            }
        }
        return res;
    }
    
    private boolean isPalindrome(String word) {
        int l = 0, r = word.length() - 1;
        while (l <= r) {
            if (word.charAt(l++) != word.charAt(r--)) {
                return false;
            }
        }
        return true;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
