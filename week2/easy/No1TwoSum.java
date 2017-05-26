package ArrayEasy;

import java.util.HashMap;
import java.util.Map;

public class No1TwoSum {
	
	public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for(int i=0; i<=nums.length-1; i++){
            
            if(map.containsKey(target-nums[i])){
                res[0]= map.get(target-nums[i]);
                res[1]=i;
                return res;
            }
            
            map.put(nums[i],i);
        }
        
        return res;
    }
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
