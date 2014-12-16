
public class SortList {
	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
	
	
	/*
	public ListNode merge(ListNode h1, ListNode h2) {
		ListNode newHead;
		if (h1 == null) {
			return h2;
		}
		if (h2 == null) {
			return h1;
		}
		if (h1.val < h2.val) {
			newHead = new ListNode(h1.val);
			//h1 = h1.next;
			newHead.next = new ListNode(h2.val);
			//h2 = h2.next;
		}
		else {
			newHead = new ListNode(h2.val);
			newHead.next = new ListNode(h1.val);
		}
		
		ListNode pointer = newHead.next;
		
		while (h1.next != null && h2.next != null) {
			//System.out.println("h1 = " + h1.next.val + "; h2 = " + h2.next.val);
			if (h1.next.val < h2.next.val) {
				pointer.next = new ListNode(h1.next.val);
				h1 = h1.next;
				pointer = pointer.next;
				pointer.next = new ListNode(h2.next.val);
				h2 = h2.next;
			}
			else {
				pointer.next = new ListNode(h2.next.val);
				h2 = h2.next;
				pointer = pointer.next;
				pointer.next = new ListNode(h1.next.val);
				h1 = h1.next;
			}
		}
		System.out.println("end while");
		if (h1.next == null) {
			pointer.next = new ListNode(h1.val);
			pointer = pointer.next;
			while (h2.next != null) {
				pointer.next = new ListNode(h2.next.val);
				h2 = h2.next;
				pointer = pointer.next;
			}
			
		}
		else {
			//System.out.println("else");
			//System.out.println("h2.val = " + h2.val);
			pointer.next = new ListNode(h2.val);
			pointer = pointer.next;
			while (h1.next != null) {
				pointer.next = new ListNode(h1.next.val);
				h1 = h1.next;
				pointer = pointer.next;
			}
			
		}
		return newHead;
	}
	*/
	
	public ListNode sortList(ListNode head) {
		return mergeSort(head);
    }
	
	public ListNode mergeSort(ListNode head) {
		//printList(head);
		if (head == null || head.next == null) {
			return head;
		}
		if (head.next.next == null) {
			ListNode head2 = head.next;
			head.next = null;
			return merge(head, head2);
		}
		ListNode fast = head;
		ListNode slow = head;
		while (fast.next!= null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		ListNode head2 = slow.next;
		//System.out.println("head2 = " + head2.val);
		slow.next = null;
		//System.out.println("divide: ");
		//printList(head);
		//printList(head2);
		head = mergeSort(head);
		head2 = mergeSort(head2);
		return merge(head, head2);
	}
	
	public ListNode merge(ListNode h1, ListNode h2) {
		if (h1 == null) {
			//System.out.println("h2 = " + h2.val);
			return h2;
		}
		if (h2 == null) {
			//System.out.println("h1 = " + h1.val);
			return h1;
		}
		//System.out.println("h1 = " + h1.val + "; h2 = " + h2.val);
		ListNode dummy = new ListNode(0);
		if (h1.val < h2.val) {
			dummy.next = h1;
			h1 = h1.next;
		}
		else {
			dummy.next = h2;
			h2 = h2.next;
		}
		ListNode pointer = dummy.next;
		while (h1 != null && h2 != null) {
			//System.out.println("h1 = " + h1.val + "; h2 = " + h2.val);
			if (h1.val < h2.val) {
				pointer.next = h1;
				h1 = h1.next;
				pointer = pointer.next;
				
			}
			else {
				pointer.next = h2;
				h2 = h2.next;
				pointer = pointer.next;
				
			}
		}
		if (h1 == null) {
			while (h2 != null) {
				pointer.next = h2;
				h2 = h2.next;
				pointer = pointer.next;
			}
		}
		else {
			while (h1 != null) {
				pointer.next = h1;
				h1 = h1.next;
				pointer = pointer.next;
			}
		}
		//System.out.println("after merge: ");
		//printList(dummy.next);
		return dummy.next;
	}
	
	public void printList(ListNode head) {
		while (head != null) {
			System.out.print(head.val + " -> ");
			head = head.next;
		}
		System.out.print("\n");
	}
	
	public void testMerge() {
		ListNode h1 = new ListNode(2);
		h1.next = new ListNode(3);
		h1.next.next = new ListNode(5);
		ListNode h2 = new ListNode(1);
		h2.next = new ListNode(6);
		
		ListNode head = merge(h1, h2);
		while (head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
	}
	
	public void testSortList() {
		ListNode h1 = new ListNode(5);
		h1.next = new ListNode(3);
		h1.next.next = new ListNode(2);
		h1.next.next.next = new ListNode(1);
		h1.next.next.next.next = new ListNode(6);
		
		ListNode head = sortList(h1);
		while (head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
	}
}
