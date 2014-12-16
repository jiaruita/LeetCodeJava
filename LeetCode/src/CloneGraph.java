import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;


public class CloneGraph {
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
        	return null;
        }
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>(); 
        LinkedList<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        queue.add(node);
        while (queue.size() > 0) {
        	UndirectedGraphNode n = queue.pollFirst();
        	ArrayList<UndirectedGraphNode> neighbors = n.neighbors;
        	if (!map.containsKey(n)) {
        		UndirectedGraphNode copy = new UndirectedGraphNode(n.label);
        		map.put(n, copy);
        	}
        	for (UndirectedGraphNode neighbor: neighbors) {
    			UndirectedGraphNode neighborCopy;
    			if (!map.containsKey(neighbor)) {
    				queue.add(neighbor);
    				neighborCopy = new UndirectedGraphNode(neighbor.label);
     				map.put(neighbor, neighborCopy);
     				map.get(n).neighbors.add(neighborCopy);
    			}
    			else {
    				neighborCopy = map.get(neighbor);
    				map.get(n).neighbors.add(neighborCopy);
    			}
    		}
        }
        return map.get(node);
    }
}
