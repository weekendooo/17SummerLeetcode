package DPMedium;

public class No474OnesandZeroes {

	public int findMaxForm(String[] strs, int m, int n) {
        int numZero, numOne;
        int[][] dp = new int[m + 1][n + 1];
        
        for (String s : strs) {
            numZero = 0;
            numOne = 0;
            
            for (char c : s.toCharArray()) {
                if (c == '0') numZero++;
                else if (c == '1') numOne++;
            }
            for (int i = m; i >= numZero; i--) {
                for (int j = n; j >= numOne; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - numZero][j - numOne] + 1);
                }
            }
        }
        return dp[m][n];
    }
	
	// "10", "0", "1"

	// m = 1, n = 1

	// "1 0" zeroes:1, ones:1

	// for (i = 1 -> 1) 
//	 	for (j = 1 -> 1) {
//	 	dp[1][1] = max([1][1], [0][0] + 1) = 1
	// }


	// "0" zeroes:1, ones:0

	// for (i = 1 -> 1) 
//	 	for(j = 1 -> 0) {
//	 	dp[1][1] = max([1][1], [0][1] + 1) = 1
//	 	dp[1][0] = max([1][0], [0][0] + 1) = 1
	// } 

	// "1" zeroes: 0 , ones : 1

	// for (i = 1 -> 0) {
//	 	for (j = 1 -> 1) {
//	 	dp[1][1] = max ([1][1], [1][0] + 1) = 2
//	 	dp[0][1] = max ([0][1], [0][0] + 1) = 1

//	 	}
	// }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
