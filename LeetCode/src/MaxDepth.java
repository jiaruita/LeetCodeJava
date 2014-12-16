
public class MaxDepth {
	 public int maxDepth(TreeNode root) {
	        return preorder(root);
	 }
	    
	 public int preorder(TreeNode root) {
	     	if (root == null) {
	            return 0;
	        }
	        int l = preorder(root.left);
	        int r = preorder(root.right);
	        int dep = l > r ? l : r;
	        
	        return dep+1;
	 }
	    
	 public void testDepth() {
	    	TreeNode root = new TreeNode(5);
	    	System.out.println(maxDepth(root));
	    	root.left = new TreeNode(4);
	    	System.out.println(maxDepth(root));
	 }
}
