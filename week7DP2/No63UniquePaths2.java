package DPMedium;

public class No63UniquePaths2 {

	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid[0].length;
        int[] dp = new int[n];
        dp[0] = 1;
        
        for (int[] row : obstacleGrid) {
            for (int j = 0; j < n; j++) {
                if (row[j] == 1) {
                    dp[j] = 0;
                }
                else if (j > 0) {
                    dp[j] += dp[j - 1];
                }
            }
        }
        return dp[n - 1];
    }
	
//  0 0 0  [0] = 1, [1] += [0] = 1, [2] += [1] = 1
//  0 1 0  [0] = 1, [1] = 0, [2] += [1] = 1
//  0 0 0  [0] = 1, [1] += [0] = 1, [2] += [1] = 2
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
