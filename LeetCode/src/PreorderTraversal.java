import java.util.ArrayList;




public class PreorderTraversal {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			val = x;
		}
	}
	public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        ArrayList<TreeNode> queue = new ArrayList<TreeNode>();
        recur(queue, root);
        for (TreeNode n:queue) {
        	result.add(n.val);
        }
        return result;
    }
	
	public void recur(ArrayList<TreeNode> q, TreeNode r) {
		if (r != null) {
			q.add(r);
			recur(q, r.left);
			recur(q, r.right);
		}
	}
	
	public void testPreorder() {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = null;
		root.left.right = null;
		root.right.left = new TreeNode(4);
		root.right.right = null;
		root.right.left.left = null;
		root.right.left.right = new TreeNode(5);
		
		ArrayList<Integer> arr = preorderTraversal(root);
		for (Integer i: arr) {
			System.out.println(i);
		}
	}
}
