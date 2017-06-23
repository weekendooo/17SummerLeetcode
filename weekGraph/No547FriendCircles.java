package DFS;

public class No547FriendCircles {

	// can not use solution of No200:number of islands;
    //because:  
    // 1 0 0 1
    // 0 1 1 0
    // 0 1 1 1
    // 1 0 1 1
    // 4 islands, 1 friends circle
    public int findCircleNum(int[][] M) {
        if (M.length == 0 || M == null) return 0;
        int n = M.length;
        boolean[] visited = new boolean[n];
        int count = 0;
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(M, visited, i);
                count++;
            }
        }
        return count;
    }
    private void dfs(int[][] M, boolean[] visited, int x) {
        for (int y = 0; y < M.length; y++) {
            if (M[x][y] == 1 && !visited[y]) {
                visited[y] = true;
                dfs(M, visited, y);
            }
        }
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
