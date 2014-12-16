
public class InsertSort {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x){
			val = x;
			next = null;
		}
	}
	
	public ListNode insertionSortList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		
		ListNode dummy = new ListNode(0);
		ListNode real = new ListNode(head.val);
		dummy.next = real;
		
		ListNode pointer = head.next;
		while (pointer != null) {
			ListNode prev = dummy;
			ListNode cur = dummy.next;
			while (cur != null && cur.val <= pointer.val) {
				cur = cur.next;
				prev = prev.next;
			}
			
			prev.next = new ListNode(pointer.val);
			prev = prev.next;
			prev.next = cur;
			pointer = pointer.next;
		}
		return dummy.next;
    }
	
	public void testInsertion() {
		ListNode head = new ListNode(5);
		head.next = new ListNode(3);
		head.next.next = new ListNode(9);
		head.next.next.next = new ListNode(1);
		
		ListNode newHead = insertionSortList(head);
		while (newHead != null) {
			System.out.print(newHead.val + " ");
			newHead = newHead.next;
		}
	}
}
