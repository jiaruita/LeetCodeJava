
public class RecoverBST {
	public void recoverTree(TreeNode root) {
        if (root == null) {
        	return;
        }
        TreeNode current = root;
        TreeNode prev = null;
        TreeNode cur1 = null;
        TreeNode prev1 = null;
        TreeNode cur2 = null;
        TreeNode prev2 = null;
        while (current != null) {
        	if (current.left == null) {
        		prev = current;
        		current = current.right;
        		//System.out.println("left == null; prev = " + prev.val + "; current = " + current.val);
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
        			p = current;
        			prev = current;
        			current = current.right;
        			//System.out.println("prev = " + prev.val + "; current = " + current.val);
        		}
        	}
        	if (current != null && prev != null && prev.val > current.val) {
        		System.out.println("prev = " + prev.val + "; current = " + current.val);
        		if (cur1 == null) {
        			cur1 = current;
        			prev1 = prev;
        		}
        		else {
        			cur2 = current;
        			prev2 = prev;
        		}
        	}
        }
        if (cur2 != null && prev1 != null) {
        	int temp = cur2.val;
        	cur2.val = prev1.val;
        	prev1.val = temp;
        }
        else {
        	int temp = cur1.val;
        	cur1.val = prev1.val;
        	prev1.val = temp;
        }
    }
	
	public void testRecover() {
		TreeNode root = new TreeNode(3);
		root.right = new TreeNode(2);
		root.left = new TreeNode(1);
		recoverTree(root);
		
	}
}
