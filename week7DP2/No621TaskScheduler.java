package ArrayMedium;

import java.util.Arrays;

public class No621TaskScheduler {

	public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for (char c : tasks) {
            count[c - 'A']++;
        }
        Arrays.sort(count);
        
        int i = 25;
        while (i >= 0 && count[i] == count[25]) {
            i--;
        }
        return Math.max(tasks.length, (count[25] - 1) * (n + 1) + 25 - i);
    }
	
	// ACCCEEE , n = 2

	// CEACE CE
	// 12345678

	// c[26]

	// [1, 0, 3, 0, 3, ........]
	// [0,0,0,..........1, 3, 3]
//	                  i
	//  (c[25] - 1) * (n + 1) + 25 - i 
	// = 2 * 3 + 25 - 23 = 8
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
