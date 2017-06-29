package DPEasy;
//n = 0; 0
//n = 1; 1
//n = 2; return 2: 1 + 1 or 2
//n = 3; 1 + 1 + 1,
//       1 + 2,
//       2 + 1 
//       return 3
//
//n = 4; 1 + 1 + 1 + 1
//	   2 + 2
//	   1 + 2 + 1
//	   1 + 1 + 2
//	   2 + 1 + 1
//	   return 5;
//
//n = 5; 1 + 1 + 1 + 1 + 1
//       2 + 2 + 1
//       1 + 2 + 2
//       2 + 1 + 2
//       1 + 1 + 1 + 2
//       1 + 1 + 2 + 1
//       1 + 2 + 1 + 1
//       2 + 1 + 1 + 1
//       return 8;
public class No70ClimbingStairs {

	public int climbStairs(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        
        // int[] res = new int[n + 1];
        // res[0] = 0;
        // res[1] = 1;
        // res[2] = 2;
        // for (int i = 3; i < n + 1; i++) {
        //     res[i] = res[i - 1] + res[i - 2];
        // } 
        // return res[n];
        
        int lastOne = 2;
        int lastTwo = 1;
        int res = 0;
        for (int i = 2; i < n; i++) {
            res = lastOne + lastTwo;
            lastTwo = lastOne;
            lastOne = res;
        }
        return res;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
