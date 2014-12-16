import java.util.ArrayList;


public class PathSum {
	ArrayList<Integer> sums = new ArrayList<Integer>();
	public boolean hasPathSum(TreeNode root, int sum) {
        
        int s = 0;
        if (root == null) {
        	if (sum == 0) {
        		return true;
        	}
        	else {
        		return false;
        	}
        }
        preorder(root, 0);
        for (Integer x: sums) {
        	if (x == sum) {
        		return true;
        	}
        }
        return false;
    }
	public void preorder(TreeNode root, int prev) {
		if (root.left == null && root.right == null) {
			sums.add(prev + root.val);
			return;
		}
		if (root.left != null) {
			preorder(root.left, prev + root.val);
		}
		if (root.right != null) {
			preorder(root.right, prev + root.val);
		}
	}
	
	public void testSum() {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.right = new TreeNode(2);
		System.out.println(hasPathSum(root, 6));
	}
}
