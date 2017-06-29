package DPMedium;

public class No221MaximalSquare {

	public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int len = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int value = matrix[i][j] - '0';
                if (value == 0) continue;
                
                if (i == 0 || j == 0) {
                    dp[i][j] = value;
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j])) + 1;
                }
                len = Math.max(len, dp[i][j]);
            }
        }
        return len * len;
    }
	
	// 0 0 1 1  0   0 0 1 1 
	// 0 1 0 1  1   0 1 0 1
	// 0 1 1 0  2   0 1 1 0
	// 0 1 1 0  3   0 1 2 0

	// 0 1 2 3      0 1 2 3
	 
	// m = 4, n = 4

	// b[5][5]

	// 1. i = 0, j = 2
	// value = [0][2] - 0 = 1
	// dp[0][2] = value = 1;
	// len = max (len, dp[0][2]) = 1;

	// 2. i = 0, j = 3
	// value = 1
	// dp[0][3] = 1
	// len = 1;

	// 3. i = 1, j = 1
	// dp[1][1] = min([1][1-1], [1-1][1-1]) = 0
//	           min(0, [1-1][1]) = 0
//	           0 + 1 = 1
	// len = max (len, dp[1][1]) = 1;

	// 4. i = 1, j = 3
	// dp[1][3] = min([1][3-1], [1-1][3-1]) = 0
//	           min(0, [1-1][3]) = 0
//	           0 + 1 = 1
	// len = 1;
	
	// 5. i = 2, j = 1
	// dp[2][1] = min ([2][1-1], [2-1][1-1]) = 0
//	           min (0, [2-1][1]) = 0
//	           0 + 1 = 1
	// len = 1

	// 6. i = 2, j = 2
	// dp[2][2] = min[2][1], [1][1] = 1
//	           min (1, [1][2]) = 0
//	           0 + 1 = 1
	// len = 1

	// 7. i = 3, j = 1
	// dp[3][1] = min [2][0], [3][0] = 0
//	           min = 0
//	           0 + 1 = 1;
	// len = 1;

	// 8. i = 3, j = 2
	// dp[3][2] = min[3][1], [2][1] = 1
//	           min 1, [2][2] = 1
//	           1 + 1 = 2;
	// len = max (len, dp[3][2]) = 2;

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
