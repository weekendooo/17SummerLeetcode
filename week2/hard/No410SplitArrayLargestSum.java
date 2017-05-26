package binarySearchHard;

public class No410SplitArrayLargestSum {

	public int splitArray(int[] nums, int m) {
        int max = 0;
        long sum = 0;
        for(int n : nums) {
            sum += n;
            max = Math.max(max, n);
        }

        if(m == 1) return (int)sum;
        
        long left = max, right = sum;
        while(left <= right) {
            long mid = left + (right-left)/2;
            if(isLessThanM(nums, m, mid)) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        
        return (int)left;
    }
    
    private static boolean isLessThanM(int[] nums, int m, long target) {
        long total = 0, count = 1;
        for(int n : nums) {
            total += n;
            if(total > target) {
                total = n;
                count ++;
                if(count > m) return false;
            }
        }
        
        return true;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
