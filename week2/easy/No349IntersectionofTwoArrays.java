package sortEasy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class No349IntersectionofTwoArrays {

	public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        int i=0,j=0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        while(i<=nums1.length-1 && j<=nums2.length-1){
            if(nums1[i]<nums2[j]){
                i++;
            }
            else if(nums1[i]>nums2[j]){
                j++;
            }
            else{
                set.add(nums1[i]);
                i++;
                j++;
            }
        }
        
        int[] res = new int[set.size()];
        int k = 0;
        
        for(Integer n : set){
            res[k] = n;
            k++;
        }
        
        return res;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
