import java.util.ArrayList;



public class LevelOrderTraversal {
	/*
	public class TreeNode {
		int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	}*/
	
	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<TreeNode> queue = new ArrayList<TreeNode>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (root == null) {
        	 return result;
        }
        queue.add(root);
        int current = 1;
        int next = 1;
        int idx = 0;
        while (true) {
        	if (idx >= queue.size()){
        		break;
        	}
        	current = next;
        	next = current * 2;
        	ArrayList<Integer> level = new ArrayList<Integer>();
        	for (int i = 0; i < current; i++) {
        		TreeNode temp = queue.get(idx);
        		level.add(temp.val);
        		if (temp.left == null) {
        			next  -= 1;
        		}
        		else {
        			queue.add(temp.left);
        		}
        		if (temp.right == null) {
        			next -= 1;
        		}
        		else {
        			queue.add(temp.right);
        		}
        		idx++;
        	}
        	result.add(level);
        }
        return result;
    }
	
	public void testLevelOrder(){
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = null;
		root.left.right = null;
		root.right.left = new TreeNode(4);
		root.right.right = null;
		root.right.left.left = null;
		root.right.left.right = new TreeNode(5);
		
		ArrayList<ArrayList<Integer>> arr = levelOrder(root);
		for (ArrayList<Integer> a: arr) {
			for (Integer i: a) {
				System.out.print(i + " ");
			}
			System.out.print("\n");
		}
	}
}
