import java.util.ArrayList;


public class PostorderTraversal {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			val = x;
		}
	}
	
	public ArrayList<Integer> postorderTraversal(TreeNode root) {
		ArrayList<TreeNode> queue = new ArrayList<TreeNode>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        recur(queue, root);
        for (TreeNode node:queue) {
        	result.add(node.val);
        }
        return result;
    }
	
	public void recur(ArrayList<TreeNode> q, TreeNode node) {
		if (node != null) {
			recur(q, node.left);
			recur(q, node.right);
			q.add(node);
		}
	}
}
