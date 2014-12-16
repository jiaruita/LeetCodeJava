
public class BalancedBinaryTree {
	public boolean isBalanced(TreeNode root) {
        if (root == null) {
        	return true;
        }
        if (depth(root) == -1) {
        	return false;
        }
        return true;
    }
	
	public int depth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = depth(root.left);
		int right = depth(root.right);
		if (left > right + 1 || right > left + 1 || left == -1 || right == -1) {
			return -1;
		}
		return left > right ? left + 1: right + 1;
	}
}
