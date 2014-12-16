import java.util.LinkedList;


public class SymmetricTree {
	/*
	public boolean isSymmetric(TreeNode root) {
        if (root == null) {
        	return true;
        }
        return recur(root.left, root.right);
    }
	public boolean recur(TreeNode left, TreeNode right) {
		if (left == null && right == null) {
			return true;
		}
		if (left == null || right == null || left.val != right.val) {
			return false;
		}
		boolean out = recur(left.left, right.right);
		boolean in = recur(left.right, right.left);
		return out && in;
	}
	*/
	
	public boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return true;
		}
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		queue.add(root);
		while(queue.size() > 0) {
			TreeNode left = queue.removeFirst();
			TreeNode right = queue.removeFirst();
			if (left == null && right == null) {
				continue;
			}
			if (left == null || right == null || left.val != right.val) {
				return false;
			}
			queue.add(left.left);
			queue.add(right.right);
			queue.add(left.right);
			queue.add(right.left);
		}
		return true;
    }
	
	
	public void testSymmetric() {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right=  new TreeNode(2);
		System.out.println(isSymmetric(root));
	}
}
