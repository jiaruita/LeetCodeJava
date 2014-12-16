import java.util.HashMap;
import java.util.HashSet;


public class CopyListRandomPointer {
	/*
	public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
        	return head;
        }
        HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode p = head;
        while(p != null) {
        	map.put(p, new RandomListNode(p.label));
        	p = p.next;
        }
        p = head;
        while(p != null) {
        	RandomListNode temp = map.get(p);
        	temp.next = map.get(p.next);
        	temp.random = map.get(p.random);
        	p = p.next;
        }
        return map.get(head);
    }
	*/
	
	public RandomListNode copyRandomList(RandomListNode head) {
		if (head == null) {
			return head;
		}
		RandomListNode p = head;
		while (p != null) {
			RandomListNode temp = p.next;
			p.next = new RandomListNode(p.label);
			p.next.next = temp;
			p = temp;
		}
		p = head;
		while (p != null) {
			RandomListNode copy = p.next;
			if (p.random != null) {
				copy.random = p.random.next;
			}
			p = p.next.next;
		}
		printRandomList(head);
		p = head;
		RandomListNode dummy = new RandomListNode(0);
		RandomListNode prev = dummy;
		while (p != null) {
			//System.out.println("p = " + p.label + "; p.next = " + p.next.label + "; p.next.next = " + p.next.next.label);
			System.out.println("p = " + p.label);
			printRandomList(head);
			prev.next = p.next;
			p.next = p.next.next;
			prev = prev.next;
			p = p.next;
		}
		return dummy.next;
	}
	
	public void printRandomList(RandomListNode head) {
		RandomListNode p = head;
		while(p != null) {
			System.out.println("label = " + p.label + "; random = " + p.random.label);
			p = p.next;
		}
		System.out.println("");
	}
	
	public void test() {
		RandomListNode head = new RandomListNode(0);
		RandomListNode one = new RandomListNode(1);
		RandomListNode two = new RandomListNode(2);
		head.next = one;
		one.next = two;
		head.random = head;
		one.random = two;
		two.random = head;
		printRandomList(head);
		RandomListNode newHead = copyRandomList(head);
		printRandomList(newHead);
		head.label = -1;
		head.random = one;
		printRandomList(head);
		printRandomList(newHead);
	}
}
