package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class UndirectedGraphNode {
	 int label;
	 List<UndirectedGraphNode> neighbors;
	 UndirectedGraphNode(int x) { label = x; 
	 	neighbors = new ArrayList<UndirectedGraphNode>(); }
}

public class No133CloneGraph {

	Map<Integer, UndirectedGraphNode> map = new HashMap<>();
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        return clone(node);
    }
    
    private UndirectedGraphNode clone(UndirectedGraphNode node) {
        if (node == null) return null;  // return null
        
        UndirectedGraphNode value = map.get(node.label);
        if (value != null) return value;
        
        UndirectedGraphNode cur = new UndirectedGraphNode (node.label);
        map.put(cur.label, cur);
        for (UndirectedGraphNode neighbor : node.neighbors) {  // 不用while 用recuresive把所有点都遍历完
            cur.neighbors.add(clone(neighbor));
        }
        return cur;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
