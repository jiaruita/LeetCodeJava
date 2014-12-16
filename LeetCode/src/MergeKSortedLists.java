import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;


public class MergeKSortedLists {
	public ListNode mergeKLists(ArrayList<ListNode> lists) {
		int k = lists.size();
		if (k == 0) {
			return null;
		}
		if (k == 1) {
			return lists.get(0);
		}
		while (lists.size() > 1) {
			System.out.println("before: " + lists.size());
			int size = lists.size();
			for (int i = 0; i < size / 2; i++) {
				ListNode min = mergeTwo(lists.get(i), lists.get(size - 1 - i));
				printList(min);
				lists.set(i, min);
				lists.remove(size - 1 - i);
				System.out.println("after: " + lists.size());
			}
		}
		return lists.get(0);
	}
	
	public ListNode mergeTwo(ListNode h1, ListNode h2) {
		ListNode p1 = h1;
		ListNode p2 = h2;
		ListNode dummy = new ListNode(0);
		ListNode prev = dummy;
		while (p1 != null && p2 != null) {
			if (p1.val < p2.val) {
				prev.next = p1;
				prev = prev.next;
				p1 = p1.next;
			}
			else {
				prev.next = p2;
				prev = prev.next;
				p2 = p2.next;
			}
		}
		if (p1 == null) {
			prev.next = p2;
		}
		else if (p2 == null) {
			prev.next = p1;
		}
		return dummy.next;
	}
	/*
	public ListNode mergeKLists(ArrayList<ListNode> lists) {
		int k = lists.size();
		if (k == 0) {
			return null;
		}
		if (k == 1) {
			return lists.get(0);
		}
		Comparator<ListNode> comparator = new Comparator<ListNode>() {

			@Override
			public int compare(ListNode o1, ListNode o2) {
				// TODO Auto-generated method stub
				if (o1.val < o2.val) {
					return -1;
				}
				else if (o1.val > o2.val) {
					return 1;
				}
				else {
					return 0;
				}
			}
			
		};
		PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(k, comparator);
		ListNode dummy = new ListNode(0);
		ListNode p = dummy;
		for (ListNode head: lists) {
			if (head != null) {
				heap.add(head);
			}
		}
		while (heap.size() > 0) {
			ListNode min = heap.poll();
			p.next = min;
			if (min.next != null) {
				heap.add(min.next);
			}
		}
		return dummy.next;
    }
    */
	
	public void printList(ListNode head) {
		ListNode p = head;
		while(p != null) {
			System.out.print(p.val + " ");
			p = p.next;
		}
		System.out.println(" ");
	}
	
	public void test() {
		ArrayList<ListNode> arr = new ArrayList<ListNode>();
		arr.add(new ListNode(1));
		arr.add(new ListNode(0));
		mergeKLists(arr);
		
	}
}
