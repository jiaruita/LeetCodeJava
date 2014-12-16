import java.util.LinkedList;
import java.util.Queue;


public class MinDepth {
	 public int minDepth(TreeNode root) {
		 int depth = 1;
		 int level = 1;
		 int count = 0;
		 int dis = 0;
		 if (root == null) {
			 return 0;
		 }
		 LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		 queue.add(root);
		 while(queue.size() > 0) {
			 TreeNode node = queue.removeFirst();
			 System.out.println("node: " + node.val + "; depth = " + depth + "; level = " +level);
			 count++;
			 if (node.left == null && node.right == null) {
				 return depth;
			 }
			 
			 if (node.left != null) {
				 queue.add(node.left);
			 }
			 else {
				 dis++;
			 }
			 if (node.right != null) {
				 queue.add(node.right);
			 }
			 else {
				 dis++;
			 }
			 if (count == level) {
				 level = level * 2 - dis;
				 depth++;
				 count = 0;
				 dis = 0;
			 }
		 }
		 return depth;
	 }
	 
	 public void testDepth() {
		 TreeNode root = new TreeNode(1);
		 root.left = new TreeNode(2);
		 root.left.left = new TreeNode(3);
		 root.left.left.left = new TreeNode(4);
		 root.left.left.left.left = new TreeNode(5);
		 //root.left = new TreeNode(4);
		 //root.right = new TreeNode(3);
		 //root.right.left = new TreeNode(2);
		 System.out.println(minDepth(root));
	 }
}
