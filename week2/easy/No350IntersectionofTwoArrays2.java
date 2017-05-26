package sortEasy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class No350IntersectionofTwoArrays2 {

	public int[] intersect(int[] nums1, int[] nums2) {
        Map <Integer, Integer> map = new HashMap<Integer, Integer>();
        List<Integer> list = new ArrayList<Integer>();
        
        for(int i=0; i<=nums1.length-1;i++){
            if(map.containsKey(nums1[i])){
                map.put(nums1[i],map.get(nums1[i])+1);
            }
            
            else map.put(nums1[i],1);
        }
        
        for(int i=0; i<=nums2.length-1; i++){
            if(map.containsKey(nums2[i]) && map.get(nums2[i])>0){
                list.add(nums2[i]);
                map.put(nums2[i],map.get(nums2[i])-1);
            }
        }
        
        int[] res = new int[list.size()];
        
        for(int i=0;i<=list.size()-1;i++){
            res[i]=list.get(i);
        }
        
        return res;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
