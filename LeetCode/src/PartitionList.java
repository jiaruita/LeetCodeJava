
public class PartitionList {
	public ListNode partition(ListNode head, int x) {
        ListNode less = new ListNode(0);
        ListNode lessHead = less;
        ListNode great = new ListNode(0);
        ListNode greatHead = great;
        ListNode pointer = head;
        while (pointer != null) {
        	if (pointer.val < x) {
        		less.next = new ListNode(pointer.val);
        		less = less.next;
        	}
        	else {
        		great.next = new ListNode(pointer.val);
        		great = great.next;
        	}
        	
        	pointer = pointer.next;
        }
        less.next = greatHead.next;
        head = lessHead.next;
        return head;
        
    }
	public void testPartition() {
		ListNode head = new ListNode(9);
		head.next = new ListNode(2);
		head.next.next = new ListNode(6);
		head.next.next.next = new ListNode(4);
		ListNode newHead = partition(head, 5);
		while (newHead != null) {
			System.out.print(newHead.val + " ");
			newHead = newHead.next;
		}
	}
}
