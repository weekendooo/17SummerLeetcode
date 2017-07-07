package DPMedium;

public class No413ArithmeticSlices {

	public int numberOfArithmeticSlices(int[] A) {
        if (A.length < 3) return 0;
        
        int cur = 0, sum = 0;
        for (int i = 2; i < A.length; i++) {
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                cur += 1;
                sum += cur;  // ! !
            } else {
                cur = 0;
            }
        }
        return sum;
    }
	
	// A = [1, 2, 3, 4, 5]
	// return 6: 123, 1234, 12345, 234, 2345, 345
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
