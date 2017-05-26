package ArrayEasy;

public class No35SearchInsertPosition {
	
	public int searchInsert(int[] nums, int target) {
        if(nums.length == 0) return -1;
        int left = 0, right = nums.length-1;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(nums[mid] == target){
                return mid;
            }
            else if(nums[mid]<target){
                left = mid+1;
            }
            else if(nums[mid]>target){
                right = mid-1;
            }
            
        }
        return right+1;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
