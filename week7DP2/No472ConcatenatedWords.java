package DPHard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class No472ConcatenatedWords {

	public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> res = new ArrayList<>();
        Set<String> preWords = new HashSet<>();
        Arrays.sort(words, new Comparator<String>(){
            @Override
            public int compare(String s1, String s2) {
                return Integer.compare(s1.length(), s2.length());
            }
        });
        
        for (int i = 0; i < words.length; i++) {
            if (canForm(words[i], preWords)) {
                res.add(words[i]);
            }
            preWords.add(words[i]);
        }
        return res;
    }
    
    private boolean canForm(String word, Set<String> dict) {  // No.139 word break
        if (dict.isEmpty()) return false;
        boolean[] dp = new boolean[word.length() + 1];
	    dp[0] = true;
        for (int j = 1; j <= word.length(); j++) {
            for (int i = 0; i < j; i++) {
                if (!dp[i]) continue;
                if (dict.contains(word.substring(i, j))) {
                    dp[j] = true;
                    break;
                }
            }
        }
        return dp[word.length()];
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
