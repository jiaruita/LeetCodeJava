
public class Flatten {
	 public void flatten(TreeNode root) {
		 if (root == null) {
			 return;
		 }
		 while (root != null) {
			 TreeNode right = root.right;
			 TreeNode left = root.left;
			 if (left != null) {
				 while (left.right != null) {
					 left = left.right;
				 }
				 left.right = right;
				 root.right = root.left;
				 root.left = null;
			 }
			 root = root.right;
		 }
	 }
}
