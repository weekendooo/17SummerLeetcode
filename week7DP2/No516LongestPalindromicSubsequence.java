package DPMedium;

public class No516LongestPalindromicSubsequence {

	public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];
        
        for (int i = s.length() - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][s.length() - 1];
    }
	
	// dp[i][j]: the longest palindromic subsequence's length of substring(i, j)
	// State transition:
	// dp[i][j] = dp[i+1][j-1] + 2 if s.charAt(i) == s.charAt(j)
	// otherwise, dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1])
	// Initialization: dp[i][i] = 1

	// b b b a b
	// 0 1 2 3 4

	// dp[5][5]

	// i = 4, [4][4] = 1
	// i = 3, [3][3] = 1, j = 4, [3][4] = max [4][4], [3][3] = 1
	// i = 2, [2][2] = 1, 
//	 	   j = 3, [2][3] = max [2][2], [3][3] = 1
//	 	   j = 4, [2][4] = [3][3] + 2 = 3

	// i = 1, [1][1] = 1
//	       j = 2, 
//	       ......
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
