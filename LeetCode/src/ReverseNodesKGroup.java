
public class ReverseNodesKGroup {
	public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k <= 1) {
        	return head;
        }
        int count = 0;
        ListNode newHead = reverse(head, k);
        
        ListNode nextHead = head.next;
        //head = nextHead;
        
        while (nextHead != null) {
        	//System.out.println("next = " + next.val);
        	head.next = reverse(nextHead, k);
        	head = nextHead;
        	nextHead = nextHead.next;
        }
        return newHead;
    }	
	
	public ListNode reverse(ListNode head, int k) {
		System.out.println("before: ");
		printList(head);
		if (head == null) {
			return head;
		}
		int count = 0;
		ListNode p = head;
		while (p != null) {
			p = p.next;
			count++;
		}
		if (count < k) {
			return head;
		}
		
		ListNode prev = head;
		ListNode cur = head.next;
		count = 1;
		ListNode temp = null;
		while (count++ < k) {
			temp = cur.next;
			cur.next = prev;
			prev = cur;
			cur = temp;
		}
		head.next = temp;
		ListNode newHead = prev;
		System.out.println("after:");
		printList(newHead);
		return newHead;
	}
	
	public void printList(ListNode head) {
		ListNode p = head;
		while(p != null) {
			System.out.print(p.val + " ");
			p = p.next;
		}
		System.out.println("\n");
	}
	
	public void test() {
		ListNode head = new ListNode(1);
		ListNode two = new ListNode(2);
		ListNode three = new ListNode(3);
		head.next = two;
		two.next = three;
		three.next = new ListNode(4);
		three.next.next = new ListNode(5);
		three.next.next.next = new ListNode(6);
		//three.next.next.next.next =new ListNode(7);
		//ListNode newHead = reverseKGroup(head,2);
		//printList(newHead);
	}
}
