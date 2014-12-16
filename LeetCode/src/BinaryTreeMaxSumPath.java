
public class BinaryTreeMaxSumPath {
	int curMax;
	public int maxPathSum(TreeNode root) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        curMax = Integer.MIN_VALUE;
        recur(root);
        return curMax;
    }
	
	public int recur(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int val = root.val;
		int cur = val;
		int left = recur(root.left);
		int right = recur(root.right);
		if (left > 0) {
			cur += left;
		}
		if (right > 0) {
			cur += right;
		}
		//System.out.println("val = " + val + "; curMax = " + curMax);
		if (cur > curMax) {
			curMax = cur;
		}
		System.out.println("return val = " + val);
		return Math.max(val, Math.max(val + left, val + right));
	}
	
	public void test() {
		TreeNode root = new TreeNode(-2);
		root.left = new TreeNode(1);
		System.out.println(maxPathSum(root));
	}
}
