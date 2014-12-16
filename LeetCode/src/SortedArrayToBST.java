
public class SortedArrayToBST {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			val = x;
			left = null;
			right = null;
		}
	}
	
	public TreeNode sortedArrayToBST(int[] num) {
		if (num.length == 0) {
			return null;
		}
        return formTree(num, 0, num.length - 1);
    }
	
	public TreeNode formTree(int[] num, int from, int to) {
		if (to == from) {
			return new TreeNode(num[to]);
		}
		if (to - from == 1) {
			TreeNode root = new TreeNode(num[from]);
			root.right = new TreeNode(num[to]);
			return root;
		}
		int middle = from + (to - from) / 2;
		TreeNode left = formTree(num, from, middle - 1);
		TreeNode right = formTree(num, middle + 1, to);
		TreeNode root = new TreeNode(num[middle]);
		root.left = left;
		root.right = right;
		return root;
	}
}
