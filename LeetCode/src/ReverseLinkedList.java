
public class ReverseLinkedList {
	
	public ListNode reverseBetween(ListNode head, int m, int n) {
		if (head == null || head.next == null || n == m) {
			return head;
		}
		ListNode start = null;
		ListNode prev = head;
		ListNode succ = prev.next;
		ListNode temp = null;
		if (m > 1) {
			for (int i = 1; i < m - 1; i++) {
			prev = prev.next;
			succ = prev.next;
			}
			start = prev;
			System.out.println("start = " + start.val);
			prev = prev.next;
			succ = prev.next;
		}
		for (int i = 0; i < n - m; i++) {
			System.out.println("prev = " + prev.val);
			temp = succ.next;
			succ.next = prev;
			prev = succ;
			succ = temp;
			System.out.println("succ=" + succ.val);
		}
		if (start == null) {
			head.next = succ;
			head = prev;
		}
		else {
			start.next.next = succ;
			start.next = prev;
		}
		
		return head;
	}
	
	public ListNode reverseLinkedList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode prev = head;
		ListNode succ = prev.next;
		ListNode temp = null;
		while (succ != null) {
			temp = succ.next;
			succ.next = prev;
			prev = succ;
			succ = temp;
		}
		head.next = null;
		head = prev;
		return head;
	}
	
	public void printList(ListNode head) {
		System.out.println("print:");
		ListNode p = head;
		while (p != null) {
			System.out.print(p.val + " ");
			p = p.next;
		}
		System.out.print("\n");
	}
	
	public void testReverse() {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		printList(head);
		ListNode newHead = reverseBetween(head, 1,1);
		printList(newHead);
	}
}
