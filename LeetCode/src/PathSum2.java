import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;


public class PathSum2 {
	Stack<TreeNode> stack = new Stack<TreeNode>();
	int con;
	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
		con = sum;
		
        if (root == null) {
        	return result;
        }
        stack.add(root);
        preorder(root, 0);
        stack.pop();
        return result;
    }
	
	//pre-order traversal, actually DFS
	public void preorder(TreeNode root, int prev) {
		if (root.left == null && root.right == null) {
			if (prev + root.val == con) {
				ArrayList<Integer> arr = new ArrayList<Integer>();
				Stack<TreeNode> c = (Stack<TreeNode>) stack.clone();
				while (!c.isEmpty()) {
					arr.add(c.pop().val);
				}
				Collections.reverse(arr);
				result.add(arr);
				return;
			}
			else {
				return;
			}
		}
		if (root.left != null) {
			stack.add(root.left);
			preorder(root.left, prev + root.val);
			stack.pop();
		}
		if (root.right != null) {
			stack.add(root.right);
			preorder(root.right, prev + root.val);
			stack.pop();
		}
	}
	
	public void testSum() {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.right = new TreeNode(2);
		ArrayList<ArrayList<Integer>> result = pathSum(root, 8);
		for (ArrayList<Integer> arr: result) {
			for (Integer x: arr) {
				System.out.print(x + " ");
			}
			System.out.print("\n");
		}
	}
}
