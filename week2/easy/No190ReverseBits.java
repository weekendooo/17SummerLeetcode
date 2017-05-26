package bitEasy;

public class No190ReverseBits {

	public int reverseBits(int n) {
        int res = 0;
        for(int i =0; i< 32; i++){
            res += n & 1;
            n = n>>>1;
            
            if(i<31){
                res = res << 1;  // no <<<
            }
        }
        
        return res;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
