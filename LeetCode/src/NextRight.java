import java.util.ArrayList;
import java.util.LinkedList;


public class NextRight {
	public void connect(TreeLinkNode root) {
		if (root == null) {
			return;
		}
        LinkedList<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
        queue.add(root);
        int level = 1;
        int count = 0;
        TreeLinkNode prev = null;
        while (queue.size() > 0) {
        	TreeLinkNode node = queue.removeFirst();
        	count++;
        	if (count == level) {
        		if (prev != null) {
        			prev.next = node;
        		}
        		node.next = null;
        		prev = null;
        		level *= 2;
        		count = 0;
        	}
        	else {
        		if (prev != null) {
        			prev.next = node;
        		}
        		prev = node;
        	}
        	if (node.left != null) {
        		queue.add(node.left);
        	}
        	if (node.right != null) {
        		queue.add(node.right);
        	}
        }
    }
}
