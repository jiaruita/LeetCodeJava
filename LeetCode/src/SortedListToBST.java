import java.util.ArrayList;


public class SortedListToBST {
	ListNode con;
	
	public TreeNode sortedListToBST(ListNode head) {
		con = head;
        int length = 0;
        ListNode p = head;
        while (p != null) {
        	p = p.next;
        	length++;
        }
        if (length == 0) {
        	return null;
        }
        return recur(0, length - 1);
    }
	
	public TreeNode recur(int from, int to) {
		//System.out.println("from = " + from + "; to = " + to + "; pointer = " + pointer.val);
		System.out.println("from = " + from + "; to = " + to);
		if (from > to) {
			return null;
		}
		/*
		if (from == to) {
			return new TreeNode(pointer.val);
		}
		*/
		int mid = from + (to - from)/2;
		TreeNode left = recur(from, mid - 1);
		
		TreeNode root = new TreeNode(con.val);
		System.out.println("node: " + root.val);
		con = con.next;
		root.left = left;
		System.out.print("left child of parent: " + root.val + " is: ");
		if (left == null) {
			System.out.println("null");
		}
		else {
			System.out.println(left.val);
		}
		TreeNode right = recur(mid + 1, to);
		
		root.right = right;
		System.out.print("right child of parent: " + root.val + " is: ");
		if (right == null) {
			System.out.println("null");
		}
		else {
			System.out.println(right.val);
		}
		return root;
	}
	
	public void printTree(TreeNode root) {
		LevelOrderTraversal l = new LevelOrderTraversal();
		ArrayList<ArrayList<Integer>> arr = l.levelOrder(root);
		for (ArrayList<Integer> a: arr) {
			for (Integer x: a) {
				System.out.print(x + " ");
			}
			System.out.print("\n");
		}
		
	}
	
	public void testRecur() {
		ListNode head = new ListNode(-10);
		head.next = new ListNode(-3);
		head.next.next = new ListNode(0);
		head.next.next.next = new ListNode(5);
		head.next.next.next.next = new ListNode(9);
		TreeNode root = sortedListToBST(head);
		printTree(root);
	}
}
