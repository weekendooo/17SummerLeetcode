package TreeHard;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) {
		val = x;
	}
}

public class No124BinaryTreeMaximumPathSum {

int maxVal;
    
    public int maxPathSum(TreeNode root) {
        maxVal = Integer.MIN_VALUE;
        helper(root);
        return maxVal;
    }
    
    private int helper(TreeNode root) {
        if(root == null) return 0;
        int left = Math.max(0, helper(root.left));
        int right = Math.max(0, helper(root.right));
        maxVal = Math.max(maxVal, left + right + root.val);
        return Math.max(left, right) + root.val;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
