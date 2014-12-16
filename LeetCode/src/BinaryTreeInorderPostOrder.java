
public class BinaryTreeInorderPostOrder {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
        int lin = inorder.length;
        int lpost = postorder.length;
        if (lin != lpost || lin == 0 || lpost == 0) {
        	return null;
        }
        return recur(inorder, postorder, 0, lin - 1, 0, lpost - 1);
    }
	
	public TreeNode recur(int[] inorder, int[] postorder, int instart, int inend, int poststart, int postend) {
		//System.out.println("instart = " + instart + "; inend = " + inend + "; poststart = " + poststart + "; postend = " + postend);
		if (inend == instart || poststart == postend) {
			//System.out.println("return: " + instart + " " + inend + " " + poststart + " " + postend);
			return new TreeNode(inorder[instart]);
		}
		if (instart < 0 || instart >= inorder.length || inend < 0 || inend >= inorder.length 
				|| poststart < 0 || poststart >= postorder.length || postend < 0 || postend >= postorder.length
				||instart > inend || poststart > postend) {
			return null;
		}
		TreeNode root = new TreeNode(postorder[postend]);
		int in_root = 0;
		for (int i = instart; i <= inend; i++) {
			if (inorder[i] == root.val) {
				in_root = i;
				break;
			}
		}
		root.left = recur(inorder, postorder, instart, in_root - 1, poststart, poststart + in_root - 1 - instart);
		root.right = recur(inorder, postorder, in_root + 1, inend, postend - 1 - (inend - in_root - 1), postend - 1);
		return root;
	}
	
	public void testBuild() {
		int[] in = {2,1};
		int[] post = {2,1};
		TreeNode root = buildTree(in, post);
		
	}
}
