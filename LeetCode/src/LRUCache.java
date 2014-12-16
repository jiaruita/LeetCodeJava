import java.util.HashMap;


public class LRUCache {
	public static class Node {
		int key;
		int value;
		Node prev;
		Node next;
		Node(int k, int v) {
			key = k;
			value = v;
			prev = null;
			next = null;
		}
	}
	int cap;
	HashMap<Integer, Node> map;
	Node head;
	Node tail;
	public LRUCache(int capacity) {
        map = new HashMap<Integer, Node>();
        cap = capacity;
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        Node n = map.get(key);
        if (n == null) {
        	System.out.println("get " + key + ": not contains");
        	return -1;
        }
        System.out.println("get " + key + ": contains");
        n.prev.next = n.next;
        n.next.prev = n.prev;
        tail.prev.next = n;
        n.prev = tail.prev;
        tail.prev = n;
        n.next = tail;
        return n.value;
    }
    
    public void set(int key, int value) {
    	Node n = map.get(key);
        if (n == null) {
        	System.out.println("set " + key + ", " + value + ": not contains");
        	n = new Node(key, value);
        	if (map.size() == cap) {
        		Node delete = head.next;
        		head.next = delete.next;
        		delete.next.prev = head;
        		map.remove(delete.key);
        	}
        	
        	tail.prev.next = n;
        	n.prev = tail.prev;
        	tail.prev = n;
        	n.next = tail;
        	map.put(key, n);
        }
        else {
        	System.out.println("set " + key + ", " + value + ": contains");
        	n.value = value;
        	n.prev.next = n.next;
         	n.next.prev = n.prev;
         	tail.prev.next = n;
         	n.prev = tail.prev;
         	tail.prev = n;
         	n.next = tail;
        }
    }
    
    public void test() {
    	Node head = new Node(-1,-1);
    	Node tail = new Node(-1,-1);
    	head.next = tail;
    	tail.prev = head;
    	LRUCache cache = new LRUCache(1);
    	cache.set(2, 1);
    	cache.get(1);
    	
    }
}
