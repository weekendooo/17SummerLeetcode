package DPMedium;

import java.util.Arrays;

public class No300LongestIncreasingSubsequence {

	public int lengthOfLIS(int[] nums) {
        int dp[] = new int[nums.length];
        int length = 0, index = 0;
        
        for(int n : nums) {
            index = Arrays.binarySearch(dp, 0, length, n);
            if(index < 0) {
                index = -(index + 1);
            }
            dp[index] = n;
            if(index == length) length++;
        }
        return length;
    }
	
	public static void main(String[] args) {
		int[] dp = new int[]{2,5,0,0,0,0};
		int len = 2;
		int change = 1;
		System.out.println(Arrays.binarySearch(dp, 0, len, change));

	}

}
