
public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        ListNode p1 = l1;
        ListNode p2 = l2;
        int carry = 0;
        while (p1 != null && p2 != null) {
        	int sum = p1.val + p2.val + carry;
        	p1 = p1.next;
        	p2 = p2.next;
        	if (sum >= 10) {
        		carry = 1;
        		sum -= 10;
        	}
        	else {
        		carry = 0;
        	}
        	p.next = new ListNode(sum);
        	p = p.next;
        }
        ListNode temp = p1 != null? p1:p2;
        while (temp != null) {
        	int sum = temp.val + carry;
        	if (sum >= 10) {
       			sum -= 10;
       			carry = 1;
       		}
       		else {
       			carry = 0;
       		}
       		p.next = new ListNode(sum);
       		p = p.next;
       		temp = temp.next;
       	}
        if (carry == 1) {
        	p.next = new ListNode(1);
        }
        return dummy.next;
    }
}
