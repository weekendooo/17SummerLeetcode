package binarySearchEasy;

import java.util.Arrays;

public class No475Heaters {

	public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int disLeft = 0, disRight = 0;
        int res = Integer.MIN_VALUE;
        
        for (int house : houses) {
            int index = Arrays.binarySearch(heaters, house);
            if(index < 0) {
                index = -(index + 1);
            }
            disLeft = index > 0 ? house - heaters[index - 1] : Integer.MAX_VALUE;
            disRight = index < heaters.length ? heaters[index] - house : Integer.MAX_VALUE;
            int closest = Math.min(disLeft, disRight);
            res = Math.max(res, closest);
        }
        
        return res;
    }
	
	public static void main(String[] args) {
		int[] arr = {0, 0, 0, 0, 0, 0, 0, 0};
		int len =6;
		int n=101;
		System.out.println(Arrays.binarySearch(arr, 0, len, n));

	}

}
