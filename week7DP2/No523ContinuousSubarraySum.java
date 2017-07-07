package DPMedium;

import java.util.HashMap;
import java.util.Map;

public class No523ContinuousSubarraySum {

	public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // !!!! case: nums[0, 0], k = 0 return true;
        int curSum = 0;
        for (int i = 0; i < nums.length; i++) {
            curSum += nums[i];
            if (k != 0) {
                curSum %= k; 
            }
            Integer value = map.get(curSum);
            if (value != null) {
                if (i - value > 1) {
                    return true;
                }
            } else {
                map.put(curSum, i);
            }
        }
        return false;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
