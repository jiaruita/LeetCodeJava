import java.util.LinkedList;


public class NextRight2 {
	 public void connect(TreeLinkNode root) {
		 if (root == null) {
			 return;
		 }
		 LinkedList<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
		 queue.add(root);
		 int count = 0;
		 int level = 1;
		 int discount = 0;
		 TreeLinkNode prev = null;
		 while (queue.size() > 0) {
			 TreeLinkNode node = queue.removeFirst();
			 if (node.left != null) {
				 queue.add(node.left);
			 }
			 else {
				 discount++;
			 }
			 if (node.right != null) {
				 queue.add(node.right);
			 }
			 else {
				 discount++;
			 }
			 count++;
			 if (count == level) {
				 if (prev != null) {
					 prev.next = node;
					 System.out.println(prev.val + " -> next: " + node.val);
				 }
				 prev = null;
				 node.next = null;
				 System.out.println(node.val + "-> next: null");
				 level = level * 2 - discount;
				 discount = 0;
				 count = 0;
			 }
			 else {
				 if (prev != null) {
					 prev.next = node;
					 System.out.println(prev.val + " -> next: " + node.val);
				 }
				 prev = node;
			 }
			 
		 }
	 }
	 
	 public void testNext() {
		 /*
		 TreeLinkNode root = new TreeLinkNode(1);
		 root.left = new TreeLinkNode(2);
		 root.left.left = new TreeLinkNode(3);
		 root.left.left.left = new TreeLinkNode(4);
		 root.left.left.left.left = new TreeLinkNode(5);
		 */
		 TreeLinkNode root = new TreeLinkNode(1);
		 root.left = new TreeLinkNode(2);
		 root.right = new TreeLinkNode(3);
		 root.left.left = new TreeLinkNode(4);
		 root.left.right = new TreeLinkNode(5);
		 
		 connect(root);
		 
	 }
}
