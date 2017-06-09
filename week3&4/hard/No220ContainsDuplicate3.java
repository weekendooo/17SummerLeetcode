package binarySearchMedium;

import java.util.HashMap;
import java.util.Map;

public class No220ContainsDuplicate3 {

	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k < 1 || t < 0) return false;
        Map<Long, Long> map = new HashMap<Long, Long>();
        
        for (int i = 0; i < nums.length; i++) {
            long rmpN = (long) nums[i] - Integer.MIN_VALUE;
            long bucket = rmpN / ((long) t + 1);
            
            if (map.containsKey(bucket) || (map.containsKey(bucket - 1) && rmpN - map.get(bucket - 1) <= t)
                || (map.containsKey(bucket + 1) && map.get(bucket + 1) - rmpN <= t)) {
                    return true;
                }
                
            if (map.entrySet().size() >= k) {
                long lastBucket = ((long) nums[i - k] - Integer.MIN_VALUE) / ((long) t + 1);
                map.remove(lastBucket);
            }
            map.put(bucket, rmpN);
        }
        return false;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
