package binarySearchMedium;

public class No162FindPeakElement {

	public int findPeakElement(int[] nums) {
        return findPeak(nums, 0, nums.length-1);
    }
    
    private static int findPeak(int[] nums, int left, int right) {
        if(left == right) return left;
        if(right - left == 1) {
            if(nums[left] > nums[right]) {
                return left;
            }
            return right;
        }
        
        int mid = left + (right - left)/2;
        if(nums[mid - 1] < nums[mid] && nums[mid] > nums[mid + 1]) {
            return mid;
        }
        
        else if(nums[mid - 1] > nums[mid] && nums[mid] > nums[mid + 1]){
            return findPeak(nums, left, mid-1);
        }
        else return findPeak(nums, mid+1, right);
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
