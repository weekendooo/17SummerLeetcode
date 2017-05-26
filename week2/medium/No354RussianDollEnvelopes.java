package binarySearchMedium;

import java.util.Arrays;
import java.util.Comparator;

public class No354RussianDollEnvelopes {

	public int maxEnvelopes(int[][] envelopes) {
        if(envelopes == null || envelopes.length == 0) return 0;
        
        int[] dp = new int[envelopes.length];
        int len = 0, index = 0;
        
        Arrays.sort(envelopes, new Comparator<int[]>() {
            public int compare(int[] arr1, int[] arr2) {
                if(arr1[0] == arr2[0]){
                    return arr2[1] - arr1[1];
                }
                else return arr1[0] - arr2[0];
            }
        });
        
        for(int[] envelope : envelopes) {
            index = Arrays.binarySearch(dp, 0, len, envelope[1]);
            if(index < 0) {
                index = -(index + 1);
            }
            dp[index] = envelope[1];
            if(index == len) len++;
        }
        
        return len;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
