package StringEasy;

import java.util.Stack;

public class No20ValidParentheses {
	 public boolean isValid(String s) {
	        Stack<Character> stack = new Stack<Character>();
	        
	        for(int i =0 ; i<=s.length()-1; i++){
	            if(s.charAt(i)=='('){
	                stack.push(')');
	            }
	            
	            else if(s.charAt(i)=='['){
	                stack.push(']');
	            }
	            
	            else if(s.charAt(i)=='{'){
	                stack.push('}');
	            }
	            
	            else if(stack.isEmpty() || stack.pop()!=s.charAt(i)){
	                return false;
	            }
	        }
	        
	        return stack.isEmpty();  // if input is just '[';
	    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
