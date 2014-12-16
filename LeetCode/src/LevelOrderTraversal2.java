import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;


public class LevelOrderTraversal2 {
	public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        if (root == null) {
        	return result;
        }
        queue.add(root);
        int level = 1;
        int count = 0;
        int dis = 0;
        ArrayList<Integer> line = new ArrayList<Integer>();
        while (queue.size() > 0) {
        	TreeNode node = queue.removeFirst();
        	line.add(node.val);
        	count++;
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
        		count = 0;
        		dis = 0;
        		result.add(line);
        		line = new ArrayList<Integer>();
        	}
        }
        Collections.reverse(result);
        return result;
    }
}
