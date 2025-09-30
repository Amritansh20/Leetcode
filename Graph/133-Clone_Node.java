
import java.util.*;
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

class Solution {
    public Node cloneGraph(Node node) {
        if(node==null)
        return node;

        Map<Node,Node> visited = new HashMap<>();
        clone(node,visited);
        return visited.get(node); 
    }

    public void clone(Node node, Map<Node,Node> visited){
        Node clonedNode = new Node(node.val);
        visited.put(node,clonedNode);

        for(Node it : node.neighbors){
            if(!visited.containsKey(it)){
                clone(it,visited);
            }
            visited.get(node).neighbors.add(visited.get(it));
        }
    }
}