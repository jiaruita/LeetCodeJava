
public class ReorderList {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
	public void reorderList(ListNode head) {
		if (head == null) {
			return;
		}
        ListNode firstHalf = half(head);
        ListNode newHead = reverseList(firstHalf.next);
        firstHalf.next = null;
        ListNode firstHead = head;
        ListNode secondHead = newHead;
        while (firstHead != null && secondHead != null) {
        	ListNode temp = firstHead.next;
        	firstHead.next = secondHead;
        	firstHead = temp;
        	temp = secondHead.next;
        	secondHead.next = firstHead;
        	secondHead = temp;
        }
    }
	
	public ListNode half(ListNode root) {
		if (root == null) {
			return root;
		}
		ListNode slow = root;
		ListNode fast = root;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
	
	public ListNode reverseList(ListNode root) {
		if (root == null) {
			return root;
		}
		else if (root.next == null) {
			return root;
		}
		else if (root.next.next == null) {
			ListNode newRoot = root.next;
			newRoot.next = root;
			root.next = null;
			return newRoot;
		}
		ListNode cur = null;
		ListNode next = root;
		
		while (next != null) {
			ListNode temp = next.next;
			next.next = cur;
			cur = next;
			next = temp;
		}
		return cur;
	}
	
	public void testReverse() {
		ListNode root = new ListNode(0);
		root.next = new ListNode(1);
		root.next.next = new ListNode(2);
		root.next.next.next = new ListNode(3);
		
		ListNode newRoot = reverseList(root);
		while (newRoot != null) {
			System.out.print(newRoot.val + " ");
			newRoot = newRoot.next;
		}
	}
	
	public void testReorder() {
		ListNode root = new ListNode(0);
		root.next = new ListNode(1);
		root.next.next = new ListNode(2);
		root.next.next.next = new ListNode(3);
		
		reorderList(root);
		while(root != null) {
			System.out.print(root.val + " ");
			root = root.next;
		}
	}
}
