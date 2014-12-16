import java.util.ArrayList;
import java.util.Stack;


public class InorderTraversal {
	/*
	public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (root == null) {
        	return result;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        //stack.add(root);
        TreeNode cur = root;
        while (stack.size() > 0 || cur != null) {
        	if (cur != null) {
        		stack.add(cur);
        		cur = cur.left;
        	}
        	else {
        		cur = stack.pop();
        		result.add(cur.val);
        		cur = cur.right;
        	}
        }
        return result;
    }
    */
	/*
	public ArrayList<Integer> inorderTraversal(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (root == null) {
			return result;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.add(root);
		TreeNode cur;
		while (stack.size() > 0) {
			cur = stack.pop();
			if (cur == null) {
				if (stack.size() == 0) {
					break;
				}
				cur = stack.pop();
				result.add(cur.val);
				stack.add(cur.right);
			}
			else {
				stack.add(cur);
				stack.add(cur.left);
			}
		}
		return result;
	}*/
	//morris traversal
	public ArrayList<Integer> inorderTraversal(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (root == null) {
			return result;
		}
		TreeNode current = root;
		while (current != null) {
			if (current.left == null) {
				result.add(current.val);
				current = current.right;
			}
			else {
				TreeNode p = current.left;
				while (p.right != null && p.right != current) {
					p = p.right;
				}
				if (p.right == null) {
					p.right = current;
					current = current.left;
				}
				else {
					p.right = null;
					result.add(current.val);
					current = current.right;
				}
			}
		}
		return result;
	}
}
