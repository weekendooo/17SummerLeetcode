package DPEasy;

public class No198HouseRobber {

	public int rob(int[] nums) {
        int no = 0;
        int yes = 0;
        for (int n : nums) {
            int temp = no;
            no = Math.max(no, yes);
            yes = n + temp;
        }
        
        return Math.max(no, yes);
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
