
public class LinkedListCycle2 {
	public ListNode detectCycle(ListNode head) {
        if (head == null) {
        	return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (true) {
        	if (fast == null) {
        		return null;
        	}
        	slow = slow.next;
        	fast = fast.next;
        	if (fast == null) {
        		return null;
        	}
        	fast = fast.next;
        	if (fast == slow) {
        		break;
        	}
        }
        slow = head;
        while (slow != fast) {
        	slow = slow.next;
        	fast = fast.next;
        }
        return slow;
    }
	
	public void test() {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		ListNode result = detectCycle(head);
	}
}
