/* * LeetCode Problem: https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
* * Approach 1:
* * - We can use a level order traversal (BFS) to connect the next pointers.
* * - We use a queue to traverse each level of the tree.
* * - For each node, we connect it to the next node in the same level.
* * - We also enqueue the left and right children of the current node.
* * - At the end of each level, we set the next pointer of the last node to null.
* *
* * Time Complexity: O(N) where N is the number of nodes in the tree.
* * Space Complexity: O(N) for the queue used in level order traversal.
*/
public class PopulatingNextRightPointer {
    // Approach: Using BFS
    public Node connectBFS(Node root) {
        if (root == null)
            return root;

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
                Node next = q.poll();
                curr.next = next;
                if (next.left != null) {
                    q.add(next.left);
                    q.add(next.right);
                }
                curr = next;
            }

        }
        return root;
    }

    /* 
    * Approach 2: Using BFS Without Queue
    * - We can also perform a level order traversal without using a queue.
    * - We can use a pointer to traverse each level of the tree.
    * - For each node, we connect it to the next node in the same level.
    * - We also connect the left and right children of the current node.
    * - At the end of each level, we set the next pointer of the last node to null.
    *
    * * Time Complexity: O(N) where N is the number of nodes in the tree.
    * * Space Complexity: O(1) since we are not using any additional data structures like a queue.
    */ 

    public Node connectBFSWithoutQueue(Node root) {
        if (root == null) {
            return root;
        }
        Node level = root;
        Node curr = null;

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


    /* 
    * Approach 3: Using DFS
    * - We can also connect the next pointers using a depth-first search (DFS).
    * - We can recursively connect the left and right children of the current node.
    * - For each node, we connect it to the next node in the same level.
    * - If the current node has a left child, we connect it to the right child. 
    * - If the current node has a next node, we connect the right child to the left child of the next node.
    *
    * * Time Complexity: O(N) where N is the number of nodes in the tree.
    * * Space Complexity: O(H) where H is the height of the tree (due to recursion stack).
    */

    public Node connectDFS(Node root) {
        if (root == null) {
            return root;
        }
        dfs(root.left, root.right);
        return root;
    }
    private void dfs(Node left, Node right) {
        if (left == null || right == null) {
            return;
        }
        left.next = right;
        dfs(left.left, left.right);
        dfs(left.right, right.left);
        dfs(right.left, right.right);
    }
}
