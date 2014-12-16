
public class RotateList {
	 public ListNode rotateRight(ListNode head, int n) {
		 if (head == null || head.next == null) {
			 return head;
		 }
		 int len = 0;
		 ListNode p = head;
		 while (p != null) {
			 p = p.next;
			 len++;
		 }
		 if (n > len) {
			 n = n % len;
		 }
		 if (n == 0) {
			 return head;
		 }
		 ListNode dummy = new ListNode(0);
		 dummy.next = head;
		 ListNode fast = dummy;
		 ListNode slow = dummy;
		 for (int i = 0; i < n; i++) {
			 if (fast.next == null) {
				 return head;
			 }
			 fast = fast.next;
		 }
		 while (fast.next != null) {
			 fast = fast.next;
			 slow = slow.next;
		 }
		 ListNode newHead = slow.next;
		 slow.next = null;
		 p = newHead;
		 while (p.next != null) {
			 p = p.next;
		 }
		 p.next = dummy.next;
		 return newHead;
	 }
}
