package Graph;

public class No261GraphValidTree {

	public boolean validTree(int n, int[][] edges) {
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = -1;
        }
        
        for (int[] e : edges) {
            int x = find(nums, e[0]);
            int y = find(nums, e[1]);
            
            if (x == y) return false;
            nums[x] = y;
        }
        return n - 1 == edges.length;
    }
    
    private int find(int[] nums, int id) {
        if (nums[id] == -1) return id;
        return find(nums, nums[id]);
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
