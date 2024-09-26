// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

// Time Complexity = O(n)
// Space Complexity = O(1)
// Most optimized solution [Note: It needs to be a complete Binary Tree]
// BFS solution: Iterative
class Solution {
    public Node connect(Node root) {
        if (root == null) return root;
        Node level=root, curr=root;

        while (level.left != null) {                    // to traverse level/row wise
            while (curr != null) {                      // to traverse colomn wise
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

// Time Complexity = O(n)
// Space Complexity = O(n)
// BFS solution: Iterative
class Solution {
    public Node connect(Node root) {
        if (root == null) return root;
        Queue<Node> q = new LinkedList<Node>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();

            // for the first element in each row
            Node prev = q.poll();
            if(prev.left != null) {
                q.offer(prev.left);
                q.offer(prev.right);
            }

            // we connect the previous element to the rest of the element in each row
            for (int i=1; i<size; i++) {
                Node curr = q.poll();
                if(curr.left != null) {
                    q.offer(curr.left);
                    q.offer(curr.right);
                }
                prev.next = curr;
                prev=curr;
            }
        }

        return root;
    }
}

// DFS: Recursive
// Time Complexity = O(n)
// Space Complexity = O(h)
class Solution {
    public Node connect(Node root) {
        if (root == null) return root;
        dfs(root.left, root.right);
        return root;
    }

    private void dfs(Node left, Node right) {
        if (left == null) return;
        left.next = right;
        dfs(left.left, left.right);
        dfs(left.right, right.left);
        dfs(right.left, right.right);
    }
}