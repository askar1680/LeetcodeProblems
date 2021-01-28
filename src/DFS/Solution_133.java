package DFS;

import java.util.*;

public class Solution_133 {
    private Map<Node, Node> map = new HashMap();

    public Node cloneGraphDFS(Node node) {
        if(node == null)
            return null;
        if(map.containsKey(node))
            return map.get(node);
        Node root = new Node(node.val);
        map.put(node, root);
        for(Node ng : node.neighbors)
            root.neighbors.add(cloneGraphDFS(ng));
        return root;
    }

    public Node cloneGraphBFS(Node node) {
        if (node == null) return null;
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(node);
        Map<Node, Node> map = new HashMap<Node, Node>();
        map.put(node, new Node(node.val));
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            for (Node neighbor : current.neighbors) {
                if (!map.containsKey(neighbor)) {
                    map.put(neighbor, new Node(neighbor.val));
                    queue.add(neighbor);
                }
                map.get(current).neighbors.add(map.get(neighbor));
            }
        }
        return map.get(node);
    }

    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
