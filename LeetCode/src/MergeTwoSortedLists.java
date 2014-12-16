
public class MergeTwoSortedLists {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}
		ListNode dummy1 = new ListNode(0);
		dummy1.next = l1;
		ListNode dummy2 = new ListNode(0);
		dummy2.next = l2;
		ListNode head, p, p1, p2;
		head = new ListNode(0);
		p = head;
		p1 = dummy1;
		p2 = dummy2;
		while (p1.next != null && p2.next != null) {
			if (p1.next.val > p2.next.val) {
				p.next = p2.next;
				p2.next = p2.next.next;
			}
			else {
				p.next = p1.next;
				p1.next = p1.next.next;
			}
			p = p.next;
		}
		System.out.println("p1 = " + p1.val + "; p1 = " + p2.val);
		if (p1.next == null) {
			while (p2.next != null) {
				p.next = p2.next;
				p2.next = p2.next.next;
				p = p.next;
			}
		}
		else {
			System.out.println("2");
			while (p1.next != null) {
				System.out.println("p1 = " + p1.val + "; p1.next = " + p1.next.val);
				p.next = p1.next;
				p1.next = p1.next.next;
				p = p.next;
			}
		}
		return head.next;
    }
	
	public void testMerge() {
		ListNode head1 = new ListNode(-10);
		head1.next = new ListNode(-10);
		head1.next.next = new ListNode(-9);
		head1.next.next.next = new ListNode(-4);
		ListNode head2 = new ListNode(-7);
		ListNode newHead = mergeTwoLists(head1, head2);
		printList(newHead);
	}
	
	public void printList(ListNode head) {
		while (head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
		System.out.print("\n");
		
	}
}
