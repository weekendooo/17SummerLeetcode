package Graph;

public class No323NumberofConnectedComponentsinanUndirectedGraph {

//  5
    // [[0,1],[1,2],[0,2],[3,4]]
    public int countComponents(int n, int[][] edges) {
        int[] roots = new int[n];
        for (int i = 0; i < n; i++) {
            roots[i] = i;
        }
        
        for (int[] e : edges) {
            int root1 = find(roots, e[0]);
            int root2 = find(roots, e[1]);
            
            if (root1 != root2) {
                roots[root1] = root2; 
                n--;
            }
            
        }
        return n;
    }
    
    private int find(int[] roots, int id) {
        while (roots[id] != id) {
            roots[id] = roots[roots[id]];
            id = roots[id];
        }
        return id;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
