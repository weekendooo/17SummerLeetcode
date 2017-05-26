package binarySearchMedium;

public class No34SearchforaRange {

	public int[] searchRange(int[] nums, int target) {
	       int start = firstTarget(nums, target);
	       if(start == nums.length || nums[start] != target) return new int[]{-1,-1};
	       int end = firstTarget(nums, target+1);
	       return new int[]{start, end-1};
	       
	    }
	    
	    private static int firstTarget(int[] nums, int target) {
	        int left = 0, right = nums.length;
	        while(left < right){
	            int mid = left + (right-left)/2;
	            if(nums[mid] < target) {
	                left = mid +1;
	            }
	            else {
	                right = mid;
	            }
	        }
	        
	        return left;
	        
	    } 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
