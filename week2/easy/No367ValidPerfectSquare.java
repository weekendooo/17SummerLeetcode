package mathEasy;

public class No367ValidPerfectSquare {
	
	public boolean isPerfectSquare(int num) {
        int i=1;
        while(num>0){
            num-=i;
            i+=2;
        }
        return num == 0;
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
