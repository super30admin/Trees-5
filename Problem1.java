// Time Complexity : O(n) where n is the number of nodes
// Space Complexity : O(n) since we are storing n/2 nodes at the last level
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

/**
 * Using BFS to iterate through the tree and adding the nodes in the list. At each level, we update the next pointer of an element to the next element in the list.
 */
class StackSolution {
    public Node connect(Node root) {
        if (root == null) return null;

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            List<Node> currList = new ArrayList<>();
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node curr = q.poll();
                if (curr.left != null) q.add(curr.left);
                if (curr.right != null) q.add(curr.right);

                currList.add(curr);
            }

            for (int i = 0; i < currList.size() - 1; i++) {
                currList.get(i).next = currList.get(i + 1);
            }
        }

        return root;
    }
}

// Time Complexity : O(n) where n is the number of nodes
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
/**
 * Since it is a perfect binary tree, we can do bfs traversal and we can use the level 2's next pointers to set the level 3's next pointers since level 2's right node's next will be level 3's left node.
 */
class IterativeSolution {
    public Node connect(Node root) {
        if (root == null) return root;

        Node level = root;
        Node curr = root;

        while (level.left != null) {
            curr = level;
            while (curr != null) {
                curr.left.next = curr.right;
                if (curr.next != null) {
                    curr.right.next = curr.next.left;
                }
                curr = curr.next;
            }
            level = level.left;
        }

        return root;
    }
}
