package DPEasy;

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */

public class No303RangeSumQueryImmutable {

private int[] sum;
    
    public No303RangeSumQueryImmutable(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        sum = nums;
    }
    
    public int sumRange(int i, int j) {
        if (i == 0) return sum[j];
        return sum[j] - sum[i - 1];
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
