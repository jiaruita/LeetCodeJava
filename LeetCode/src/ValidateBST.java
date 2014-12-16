
public class ValidateBST {
	public boolean isValidBST(TreeNode root) {
        if (root == null) {
        	return true;
        }
        return recur(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
	public boolean recur(TreeNode root, int min, int max) {
		if (root == null) {
			return true;
		}
		if (root.val >= max || root.val <= min) {
			return false;
		}
		boolean left = true;
		if (root.left != null) {
			left = recur(root.left, min, root.val);
		}
		
		boolean right = true;
		if (root.right != null) {
			right = recur(root.right, root.val, max);
		}
		return left && right;
	}
	
	public void testValidate() {
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(1);
		root.right = new TreeNode(3);
		System.out.println(isValidBST(root));
	}
}
