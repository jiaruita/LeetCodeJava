
public class RemoveDuplicates {
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
        //ListNode newHead = head;
        ListNode pointer = head.next;
        ListNode prev = head;
        while (pointer != null) {
        	if (pointer.val == prev.val) {
        		pointer = pointer.next;
        		prev.next = pointer;
        	}
        	else {
        		pointer = pointer.next;
        		prev = prev.next;
        	}
        }
        return head;
    }
	
	public void testDelete() {
		ListNode head = new ListNode(1);
		head.next = new ListNode(1);
		head.next.next = new ListNode(2);
		head.next.next.next = new ListNode(3);
		ListNode newHead = deleteDuplicates(head);
		while (newHead != null) {
			System.out.print(newHead.val + " ");
			newHead = newHead.next;
		}
	}
}
