
public class RemoveDuplicates2 {
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode cur = head;
		ListNode prev = dummy;
		while (cur != null) {
			int value = cur.val;
			int flag = 0;
			while (cur.next != null && cur.next.val == value) {
				flag++;
				cur = cur.next;
			}
			if (flag == 0) {
				prev = cur;
				cur = cur.next;
			}
			else if (cur.next != null) {
				prev.next = cur.next;
				cur = prev.next;
			}
			else {
				prev.next = null;
			}
		}
		head = dummy.next;
		return head;
    }
	
	public void testDelete() {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(2);
		head.next.next.next = new ListNode(3);
		ListNode newHead = deleteDuplicates(head);
		while (newHead != null) {
			System.out.print(newHead.val + " ");
			newHead = newHead.next;
		}
		
	}
}
