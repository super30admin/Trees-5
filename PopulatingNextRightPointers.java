// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Approach

// We can use BFS to solve this problem
// We first put the root into the queue
// While q is not empty we poll the first node and then add children back to the q
// We put the loop over the size of the queue and assign them as next to curr

class Solution {
    public Node connect(Node root) {
        if (root == null)
            return null;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            Node curr = q.poll();
            if (curr.left != null) {
                q.add(curr.left);
                q.add(curr.right);
            }
            for (int i = 1; i < size; i++) {
                Node temp = q.poll();
                curr.next = temp;
                if (temp.left != null) {
                    q.add(temp.left);
                    q.add(temp.right);
                }
                curr = temp;
            }
        }
        return root;
    }
}

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Approach

// We can use DFS to solve this problem
// We take two nodes Level and curr
// while level.left is not null and curr not null we assign as necessary

class Solution {
    public Node connect(Node root) {
        if (root == null)
            return null;
        Node level = root;
        Node curr = root;
        while (level.left != null) {
            while (curr != null) {
                curr.left.next = curr.right;
                if (curr.next != null) {
                    curr.right.next = curr.next.left;
                }
                curr = curr.next;
            }
            level = level.left;
            curr = level;
        }
        return root;
    }
}
