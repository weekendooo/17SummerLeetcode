package TreeHard;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class No297SerializeandDeserializeBinaryTree {

	private static final String NULL = "null";
    private static final String SPLITER = ",";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }
    
    private void buildString(TreeNode root, StringBuilder sb) {
        if (root == null) sb.append(NULL).append(SPLITER);
        else {
            sb.append(root.val).append(SPLITER);
            buildString(root.left, sb);
            buildString(root.right, sb);
        }
    }


    private TreeNode buildTree(Deque<String> nodes) {
        String cur = nodes.remove();
        if (cur.equals(NULL)) return null;
        else {
            TreeNode node = new TreeNode(Integer.valueOf(cur));
            node.left = buildTree(nodes);
            node.right = buildTree(nodes);
            return node;
        }
    }
    
 // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Deque<String> nodes = new LinkedList<>();
        nodes.addAll(Arrays.asList(data.split(SPLITER)));
        return buildTree(nodes);
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
