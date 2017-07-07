package DPMedium;

import java.util.List;

public class No139WordBreak {

	public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        
        for (int j = 1; j <= s.length(); j++) {
            for (int i = 0; i < j; i++) {
                if (dp[i] && wordDict.contains(s.substring(i, j))) {
                    dp[j] = true;
                    break;
                }
            }
        }
        return dp[s.length()] == true;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
