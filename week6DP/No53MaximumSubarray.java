package ArrayEasy;

public class No53MaximumSubarray {

	public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        
        for (int i = 0; i <= nums.length - 1; i++) {
            if (sum < 0) {
                sum = nums[i];
            }
            else sum += nums[i];
            
            if (sum > max) {
                max = sum;
            }
        }
        return max;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
