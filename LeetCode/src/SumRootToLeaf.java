
public class SumRootToLeaf {
	public int sumNumbers(TreeNode root) {
        if (root == null) {
        	return 0;
        }
        return recur(root, 0);
    }
	
	public int recur(TreeNode root, int cur) {
		int val = cur * 10 + root.val;
		int result = 0;
		if (root.left == null && root.right == null) {
			return val;
		}
		if (root.left != null) {
			result += recur(root.left, val);
		}
		if (root.right != null) {
			result += recur(root.right, val);
		}
		return result;
	}
	
	public void testSum() {
		TreeNode root = new TreeNode(8);
		root.left = new TreeNode(3);
		root.right = new TreeNode(5);
		root.left.right = new TreeNode(9);
		root.left.right.left = new TreeNode(9);
		root.left.right.right = new TreeNode(5);
		
		System.out.println(sumNumbers(root));
	}
}
