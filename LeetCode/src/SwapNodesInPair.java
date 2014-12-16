
public class SwapNodesInPair {
	public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
        	return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode newHead = head.next;
        ListNode prev = dummy;
        ListNode cur = prev.next;
        ListNode next = null;
        ListNode temp = null;
        while(cur != null && cur.next !=null) {
        	next = cur.next;
        	temp = next.next;
        	//System.out.println("cur = " + cur.val + "; next = " + next.val + "; temp = " + temp.val);
        	cur.next = temp;
        	next.next = cur;
        	prev.next = next;
        	prev = cur;
        	cur = temp;
        }
        return newHead;
    }
	
	public void testSwap() {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		ListNode newHead = swapPairs(head);
		while (newHead != null) {
			System.out.print(newHead.val);
			newHead = newHead.next;
		}
	}
}
