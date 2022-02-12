/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach 1 - Using BFS with queue
class Solution {
    public Node connect(Node root) {
        if(root == null) {
            return null;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size > 0) {
                Node n = queue.poll();
                if(size == 1) {
                    n.next = null;
                } else {
                    n.next = queue.peek();
                }
                if(null != n.left)
                    queue.offer(n.left);
                if(null != n.right)
                    queue.offer(n.right);
                size--;
            }
        }

        return root;
    }
}

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach 2 - Using BFS without queue
class Solution {
    public Node connect(Node root) {
        if(root == null) return null;
        Node level = root;
        while(level.left != null) {
            Node curr = level;
            while(curr != null) {
                curr.left.next = curr.right;
                if(null != curr.next)
                    curr.right.next = curr.next.left;
                curr = curr.next;
            }
            level = level.left;
        }
        return root;
    }
}

// Time Complexity : O(n)
// Space Complexity : O(h), where h is the height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach 3 - Using DFS
class Solution {
    public Node connect(Node root) {
        if(root == null) return null;
        dfs(root.left, root.right);
        return root;
    }

    public void dfs(Node node1, Node node2) {
        if(null == node1) return;
        node1.next = node2;
        dfs(node1.left, node1.right);
        dfs(node1.right, node2.left);
        dfs(node2.left, node2.right);
    }
}