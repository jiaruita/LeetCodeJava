import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class ZigZag {
	public class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
	}
	
	public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
		ArrayList<ArrayList<Integer>> zigzag = new ArrayList<ArrayList<Integer>>();
		ArrayList<TreeNode> queue = levelOrder(root);
		int next = 1;
		int idx = 0;
		for (;idx < queue.size();) {
			int current = next;
			next *= 2;
			ArrayList<Integer> curLevel = new ArrayList<Integer>();
			for (int i = 0; i < current; i++) {
				
				if (queue.get(idx) == null) {
					next -= 2;
				}
				else {
					curLevel.add(queue.get(idx).val);
				}
				idx++;
			}
			zigzag.add(curLevel);
		}
		
		if (zigzag.size() == 0) {
			return zigzag;
		}
		//System.out.println("size = " + zigzag.size());
		zigzag.remove(zigzag.size() - 1);
		//System.out.println("size = " + zigzag.size());
		for (int i = 1; i < zigzag.size(); i+= 2) {
			Collections.reverse(zigzag.get(i));
		}
		return zigzag;
    }
	
	public static ArrayList<TreeNode> levelOrder(TreeNode root) {
		ArrayList<TreeNode> queue = new ArrayList<TreeNode>();
		if (root == null) {
			return queue;
		}
		queue.add(root);
		int count = 0;
		for (;;count++) {
			if (count >= queue.size()) {
				break;
			}
			TreeNode current = queue.get(count);
			if (current != null) {
				queue.add(current.left);
				queue.add(current.right);
			}
		}
		return queue;
	}
	
	public  void testLevelOrder() {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = null;
		root.left.right = null;
		root.right.left = new TreeNode(4);
		root.right.right = null;
		root.right.left.left = null;
		root.right.left.right = new TreeNode(5);
		
		ArrayList<TreeNode> queue = levelOrder(null);
		System.out.println("size: " + queue.size());
		for (TreeNode n:queue) {
			if (n == null) {
				System.out.println("null");
			}
			else{
				System.out.println(n.val);
			}
		}
	}
	
	public void testZigZag() {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = null;
		root.left.right = null;
		root.right.left = new TreeNode(4);
		root.right.right = null;
		root.right.left.left = null;
		root.right.left.right = new TreeNode(5);
		
		ArrayList<ArrayList<Integer>> zigzag = zigzagLevelOrder(root);
		for (ArrayList<Integer> arr:zigzag) {
			for (Integer i:arr) {
				System.out.print(i + " ");
				
			}
			System.out.print("\n");
		}
	}
}
