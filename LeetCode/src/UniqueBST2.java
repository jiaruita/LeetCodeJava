import java.util.ArrayList;


public class UniqueBST2 {
	public ArrayList<TreeNode> generateTrees(int n) {
        ArrayList<TreeNode> result = new ArrayList<TreeNode>();
        return recur(1, n);
    }
	
	public ArrayList<TreeNode> recur(int start, int end) {
		ArrayList<TreeNode> result = new ArrayList<TreeNode>();
		if (start > end) {
			result.add(null);
			return result;
		}
		if (start == end) {
			result.add(new TreeNode(start));
			return result;
		}
		for (int i = start; i <= end; i++) {
			ArrayList<TreeNode> left = recur(start, i - 1);
			ArrayList<TreeNode> right = recur(i + 1, end);
			for (TreeNode l: left) {
				for (TreeNode r: right) {
					TreeNode root = new TreeNode(i);
					root.left = l;
					root.right = r;
					result.add(root);
				}
			}
		}
		return result;
	}
}
