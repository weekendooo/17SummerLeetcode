package StringMedium;

public class No5LongestPalindromicSubstring {

	public String longestPalindrome(String s) {
        String res = "";
        int longest = 0;
        
        for (int i = 0; i < s.length(); i++) {          // c b a b b c a c b
            if (isPalindrome(s, i - longest, i)) {      //   |   |  longest = 3  'bab'
                res = s.substring(i - longest, i + 1); //          i = 4
                longest += 1;
            }
            else if (isPalindrome(s, i - longest - 1, i)) {
                res = s.substring(i - longest - 1, i + 1);
                longest += 2;
            }
        }
        return res;
    }
    
    private boolean isPalindrome(String s, int start, int end) {
        if (start < 0) return false;
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) return false;
        }
        return true;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
