
public class BinaryTreeInorderPreorder {
	 public TreeNode buildTree(int[] preorder, int[] inorder) {
		 int len_pre = preorder.length;
		 int len_in = inorder.length;
		 if (len_pre == 0 || len_in == 0 || len_pre != len_in) {
			 return null;
		 }
		 return recur(preorder, inorder, 0, len_in - 1, 0, len_pre - 1);
	 }
	 
	 public TreeNode recur(int[] pre, int[] in, int instart, int inend, int prestart, int preend) {
		 System.out.println("instart = " + instart + "; inend = " + inend + "; prestart = " + prestart + "; preend = " + preend);
		 if (prestart > preend || instart > inend ||
				 prestart < 0 || prestart >= pre.length || preend < 0 || preend >= pre.length ||
				 instart < 0 || instart >= in.length || inend < 0 || inend >= in.length) {
			 return null;
		 }
		 TreeNode root = new TreeNode(pre[prestart]);
		 if (prestart == preend && instart == inend) {
			 return root;
		 }
		 int in_root = 0;
		 for (int i = instart; i <= inend; i++) {
			 if (in[i] == root.val) {
				 in_root = i;
				 System.out.println("root = " + in_root);
				 break;
			 }
		 }
		 root.left = recur(pre, in, instart, in_root - 1, prestart + 1, prestart + 1 + (in_root - 1 - instart));
		 root.right = recur(pre, in, in_root + 1, inend, preend - (inend - in_root - 1), preend);
		 return root;
	 }
	 
	 public void testBuild() {
			int[] in = {1,2};
			int[] post = {1,2};
			TreeNode root = buildTree(in, post);
	}
}
