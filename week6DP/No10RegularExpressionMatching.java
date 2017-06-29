package DPHard;

public class No10RegularExpressionMatching {

	public boolean isMatch(String s, String p) {
        if (s == null || p == null) return false;
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        
        for (int j = 0; j < p.length(); j++) {
            if (p.charAt(j) == '*' && dp[0][j - 1]) {
                dp[0][j + 1] = true;
            }
        }
        for (int i = 0 ; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (p.charAt(j) == '.') {
                    dp[i+1][j+1] = dp[i][j];
                }
                if (p.charAt(j) == s.charAt(i)) {
                    dp[i+1][j+1] = dp[i][j];
                }
                if (p.charAt(j) == '*') {
                    if (p.charAt(j-1) != s.charAt(i) && p.charAt(j-1) != '.') {
                        dp[i+1][j+1] = dp[i+1][j-1];
                    } else {
                        dp[i+1][j+1] = (dp[i+1][j] || dp[i][j+1] || dp[i+1][j-1]);
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }

//  str S     str P

//1. a a       a *
//2. a b       . *
//3. a a b     c * a * b

//  i         j

//1. dp[3][3], dp[0][0] = true;
//  dp[0][2] = true;
//  i = 0, j = 0 : dp[1][1] = dp[0][0] = true;
//  i = 0, j = 1 = * : dp[1][2] = [1][1] || [0][2] || [1][0]= true;
//  i = 1, j = 0 : dp[2][1] = dp[1][0] = false;
//  i = 1, j = 1 = * : dp[2][2] = [2][1] || [1][2] || [2][0]= true;

//2. dp[3][3], dp[0][0] = true;
//  dp[0][2] = true;
//  i = 0, j = 0 = . : [1][1] = [0][0] = true;
//  i = 0, j = 1 = * : [1][2] = [1][1] || [0][2] || [1][0] = true;
//  i = 1, j = 0 = . : [2][1] = [1][0] = false;
//  i = 1, j = 1 = * : [2][2] = [2][1] || [1][2] || [2][0] = true;

//3. dp[4][6], dp[0][0] = true;
//  dp[0][2] = true; dp[0][4] = true;
//  i = 0, j = 0 : nothing
//  i = 0, j = 1 = * : [1][2] = [1][0] = false;
//  i = 0, j = 2 : [1][3] = [0][2] = true;
//  i = 0, j = 3 = * : [1][4] = [1][3] || [0][4] || [1][2] = true;
//  i = 0, j = 4 : nothing;

//  i = 1, j = 0 : nothing
//  i = 1, j = 1 = * : [2][2] = [2][0] = false;
//  i = 1, j = 2 : [2][3] = [1][2] = false;
//  i = 1, j = 3 = * : [2][4] = [2][3] || [1][4] || [2][2] = true;
//  i = 1, j = 4 : nothing;

//  i = 2, j = 0 : nothing
//  i = 2, j = 1 = * : [3][2] = [3][1] = false;
//  i = 2, j = 2 : nothing
//  i = 2, j = 3 = * : [3][4] = [3][2] = false;
//  i = 2, j = 4 : [3][5] = [2][4] = true; 

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
