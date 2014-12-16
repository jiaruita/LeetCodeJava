import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;


public class WordLadder2 {
	class Node {
		String s;
		Node parent;
		Node(String x ) {
			s = x;
		}
	}
	
	public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
	    int len = start.length();
	    dict.add(end);
	    HashMap<String, LinkedList<String>> adj = new HashMap<String, LinkedList<String>>();
	    ArrayDeque<String> queue = new ArrayDeque<String>();
	    HashSet<String> thisLevel = new HashSet<String>();
	    HashSet<String> visited = new HashSet<String>();
	    queue.add(start);
	    visited.add(start);
	    String current;
	    String temp;
	    boolean found = false;
	    char[] arr;
	    int levelSize = 1;
	    for (String s: dict) {
	    	adj.put(s, new LinkedList<String>());
	    }
	    int depth = 0;
	    while(!queue.isEmpty()) {
	    	current = queue.pollFirst();
	    	//System.out.println("current = " + current);
	    	levelSize--;
	    	for (int i = 0; i < len; i++) {
	    		arr = current.toCharArray();
	    		for (char c = 'a'; c <= 'z'; c++) {
	    			if (arr[i] != c) {
	    				arr[i] = c;
	    				temp = new String(arr);
	    				
	    				if (temp.equals(end)) {
    						found = true;
    					}
	    				if (!visited.contains(temp) && dict.contains(temp)) {
	    					//System.out.println("temp = " + temp);
	    					adj.get(current).add(temp);
	    					//System.out.println(current + ": " + adj.get(current).toString());
	    					thisLevel.add(temp);
	    				}
	    			}
	    		}
	    	}
	    	if (levelSize == 0) {
	    		depth++;
	    		if (found) {
	    			break;
	    		}
	    		//System.out.println("thisLevel: " + thisLevel.toString());
	    		levelSize = thisLevel.size();
	    		for(String s: thisLevel) {
	    			visited.add(s);
	    			queue.add(s);
	    		}
	    		thisLevel.clear();
	    	}
	    	
	    }
	   // System.out.println("depth = " + depth);
	   // printAdj(adj, dict);
	    ArrayList<String> one = new ArrayList<String>();
	    one.add(start);
	    dfs(result, adj, one, start, end, depth);
	    return result;
	}
	
	public void dfs(ArrayList<ArrayList<String>> result, HashMap<String, LinkedList<String>> adj, ArrayList<String> one, String start, String end, int depth) {
		if (depth < 0) {
			return;
		}
		if (start.equals(end)) {
			result.add(new ArrayList<String>(one));
			return;
		}
		//System.out.println("cur: " + start);
		for (String s: adj.get(start)) {
			//System.out.println("next: " + s);
			one.add(s);
			dfs(result, adj, one, s, end, depth - 1);
			one.remove(s);
		}
		return;
	}
	
	public void printAdj(HashMap<String, LinkedList<String>> adj, HashSet<String> dict) {
		System.out.println("adj size = " + adj.size());
		for (String s: dict) {
			if (adj.containsKey(s)) {
				if (adj.get(s).size() == 0) {
					continue;
				}
				System.out.println(s + ": " + adj.get(s).toString());
			}
		}
		System.out.println("");
	}
	
	/*
	public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        int len = start.length();
        boolean found = false;
        HashSet<String> visited = new HashSet<String>();
        ArrayList<Node> thisLevel = new ArrayList<Node>();
        ArrayDeque<Node> queue = new ArrayDeque<Node>();
        Node root = new Node(start);
        queue.add(root);
        queue.add(new Node(""));
        visited.add(start);
        Node curNode;
        String current;
        String temp;
        char[] arr;
        while (!queue.isEmpty()) {
        	curNode = queue.pollFirst();
        	current = curNode.s;
        	if (current.equals("")) {
        		System.out.println("level finish");
        		if (found) {
        			break;
        		}
        		
        		for(Node n : thisLevel) {
        			queue.add(n);
        			visited.add(n.s);
        		}
        		if (!queue.isEmpty()) {
        			queue.add(new Node(""));
        		}
        		thisLevel.clear();
        		continue;
        	}
        	System.out.println("current = " + current);
        	for (int i = 0; i < len; i++) {
        		arr = current.toCharArray();
        		for (char c = 'a'; c <= 'z'; c++) {
        			if (arr[i] == c) {
        				continue;
        			}
        			else {
        				arr[i] = c;
        			}
        			temp = new String(arr);
        			if (temp.equals(end)) {
        				found = true;
        				//results.add(curNode);
        				gen(result, curNode, end);
        				continue;
        			}
        			if (!visited.contains(temp) && dict.contains(temp)) {
        				Node t = new Node(temp);
        				t.parent = curNode;
        				thisLevel.add(t);
        			}
        		}
        	}
        }
        return result;
    }
	*/
	
	public void gen(ArrayList<ArrayList<String>> result, Node n, String end) {
		ArrayList<String> one = new ArrayList<String>();
    	one.add(end);
    	while (n.parent != null) {
    		one.add(n.s);n = n.parent;
    	}
    	one.add(n.s);
    	//one.add(start);
    	
    	int size = one.size();
    	for (int i = 0; i < size / 2; i++) {
    		String tempItem = one.get(i);
    		one.set(i, one.get(size - 1 - i));
    		one.set(size - 1 - i, tempItem);
    	}
    	result.add(one);
	}
	/*
	public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        int len = start.length();
        boolean found = false;
        HashSet<String> visited = new HashSet<String>();
        ArrayList<String> thisLevel = new ArrayList<String>();
        ArrayDeque<Node> queue = new ArrayDeque<Node>();
        ArrayList<Node> results = new ArrayList<Node>();
        Node root = new Node(start);
        queue.add(root);
        queue.add(new Node(""));
        visited.add(start);
        Node curNode;
        String current;
        String temp;
        char[] arr;
        while (!queue.isEmpty()) {
        	curNode = queue.pollFirst();
        	current = curNode.s;
        	if (current.equals("")) {
        		if (found) {
        			break;
        		}
        		if (!queue.isEmpty()) {
        			queue.add(new Node(""));
        		}
        		for(String s : thisLevel) {
        			visited.add(s);
        		}
        		thisLevel.clear();
        		depth++;
        		continue;
        	}
        	for (int i = 0; i < len; i++) {
        		arr = current.toCharArray();
        		for (int j = 0; j < 26; j++) {
        			arr[i] = (char)('a' + j);
        			temp = new String(arr);
        			if (temp.equals(end)) {
        				found = true;
        				results.add(curNode);
        				continue;
        			}
        			if (!dict.contains(temp)) {
        				continue;
        			}
        			if (!visited.contains(temp)) {
        				Node t = new Node(temp);
        				t.parent = curNode;
        				queue.add(t);
        				thisLevel.add(temp);
        			}
        		}
        	}
        }
        for (Node n: results) {
        	ArrayList<String> one = new ArrayList<String>();
        	one.add(end);
        	while (n.parent != null) {
        		one.add(n.s);n = n.parent;
        	}
        	one.add(n.s);
        	//one.add(start);
        	
        	int size = one.size();
        	for (int i = 0; i < size / 2; i++) {
        		String tempItem = one.get(i);
        		one.set(i, one.get(size - 1 - i));
        		one.set(size - 1 - i, tempItem);
        	}
        	result.add(one);
        }
        printResult(result);
        return result;
    }
    */

	
	public void printResult(ArrayList<ArrayList<String>> result ) {
		for (ArrayList<String> x: result) {
			System.out.println(x + ", ");
		}
		System.out.println("");
		System.out.println("");
	}
	
	
	public void test() {
		HashSet<String> dict = new HashSet<String>();
		//String start = "hot";
		//String end = "dog";
		//String[] arr = new String[]{"hot", "dog", "dot"};
		String start = "nape";
		String end = "mild";
		String[] arr = new String[]{"dose","ends","dine","jars","prow","soap","guns","hops","cray","hove","ella","hour","lens","jive","wiry","earl","mara","part","flue","putt","rory","bull","york","ruts","lily","vamp","bask","peer","boat","dens","lyre","jets","wide","rile","boos","down","path","onyx","mows","toke","soto","dork","nape","mans","loin","jots","male","sits","minn","sale","pets","hugo","woke","suds","rugs","vole","warp","mite","pews","lips","pals","nigh","sulk","vice","clod","iowa","gibe","shad","carl","huns","coot","sera","mils","rose","orly","ford","void","time","eloy","risk","veep","reps","dolt","hens","tray","melt","rung","rich","saga","lust","yews","rode","many","cods","rape","last","tile","nosy","take","nope","toni","bank","jock","jody","diss","nips","bake","lima","wore","kins","cult","hart","wuss","tale","sing","lake","bogy","wigs","kari","magi","bass","pent","tost","fops","bags","duns","will","tart","drug","gale","mold","disk","spay","hows","naps","puss","gina","kara","zorn","boll","cams","boas","rave","sets","lego","hays","judy","chap","live","bahs","ohio","nibs","cuts","pups","data","kate","rump","hews","mary","stow","fang","bolt","rues","mesh","mice","rise","rant","dune","jell","laws","jove","bode","sung","nils","vila","mode","hued","cell","fies","swat","wags","nate","wist","honk","goth","told","oise","wail","tels","sore","hunk","mate","luke","tore","bond","bast","vows","ripe","fond","benz","firs","zeds","wary","baas","wins","pair","tags","cost","woes","buns","lend","bops","code","eddy","siva","oops","toed","bale","hutu","jolt","rife","darn","tape","bold","cope","cake","wisp","vats","wave","hems","bill","cord","pert","type","kroc","ucla","albs","yoko","silt","pock","drub","puny","fads","mull","pray","mole","talc","east","slay","jamb","mill","dung","jack","lynx","nome","leos","lade","sana","tike","cali","toge","pled","mile","mass","leon","sloe","lube","kans","cory","burs","race","toss","mild","tops","maze","city","sadr","bays","poet","volt","laze","gold","zuni","shea","gags","fist","ping","pope","cora","yaks","cosy","foci","plan","colo","hume","yowl","craw","pied","toga","lobs","love","lode","duds","bled","juts","gabs","fink","rock","pant","wipe","pele","suez","nina","ring","okra","warm","lyle","gape","bead","lead","jane","oink","ware","zibo","inns","mope","hang","made","fobs","gamy","fort","peak","gill","dino","dina","tier"};
		for (String s: arr) {
			dict.add(s);
		}
		//System.out.println("dict size = " + dict.size());
		ArrayList<ArrayList<String>> result = findLadders(start, end, dict);
		printResult(result);
	}
}
