package DPHard;

public class No72EditDistance {

	public int minDistance(String word1, String word2) {
        if (word1.equals(word2)) return 0;
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        
        for (int i = 1; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j <= n; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1] + 1, 
                                    Math.min(dp[i][j - 1] + 1, dp[i - 1][j] + 1));
                }
            }
        }
        return dp[m][n];
    }
	
	// word1 : a b c
	// word2 : a b f g h
	// index : 0 1 2 3 4

	// dp[3][0] = 3 : from a b c -> null
	// dp[0][5] = 5 : from a b f g h -> null

	// dp[3][5] ?

	// 假设dp[2][4] 已知， which means we already know how to 
	// convert  a b -> a b f g

	// so
	// if 'c' == 'h' [3][5] == [2][4]
	// but 'c' != 'h';

	// there are three ways to convert:

	// 1: replace 'c' by 'h' : [2][4] + 1; 1 represents replace step;

	// 2: delete 'c', convert a b -> a b f g h : [2][5] + 1; 1 represents delete step;

	// 3: insert 'h', convert a b c -> a b f g : [3][4] + 1;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
