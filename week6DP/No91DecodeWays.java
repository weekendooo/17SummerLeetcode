package DPMedium;

public class No91DecodeWays {

	public int numDecodings(String s) {
        int n = s.length();
        if (n == 0) return 0;
        int[] dp = new int[n + 1];
        
        dp[n] = 1;
        dp[n - 1] = s.charAt(n-1) != '0' ? 1 : 0;
        
        for (int i = n - 2; i >= 0; i--) {
            if (s.charAt(i) == '0') continue;
            dp[i] = (Integer.parseInt(s.substring(i, i + 2)) <= 26) ? dp[i + 1] + dp[i + 2] : dp[i + 1];
        }
        return dp[0];
    }
	
	// string s = 123
	// 1. 1 - 2 - 3 : A - B - C
	// 2. 12 - 3 : X - C
	// 3. 1 - 23 : A - X

	// String s = 128
	// 1. 1 - 2 - 8 : A - B - X
	// 2. 12 - 8 : X - Y	

	// n = 3
	// memo size = n + 1 = 4;
	// memo[3] = 1
	// memo[2] = 1
	// memo[1] substring = 23 <= 26 : memo[2] + memo[3] = 2;
	// memo[0] substring = 12 <= 26 : memo[1] + memo[2] = 3;
	// return memo[0];


	// n = 3
	// memo size = n + 1 = 4;
	// memo[3] = 1
	// memo[2] = 1
	// memo[1] substring = 28 > 26 : memo[2] = 1;
	// memo[0] substring = 12 <= 26 : memo[1] + memo[2] = 2;
	// return memo[0];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
