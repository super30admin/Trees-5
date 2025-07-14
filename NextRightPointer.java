import java.util.LinkedList;
import java.util.Queue;

/**
 * Leetcode 116. Populating Next Right Pointers in Each Node
 * Link: https://leetcode.com/problems/populating-next-right-pointers-in-each-node/description/
 */
// ------------------------- Solution 1 --------------------------------
public class NextRightPointer {
    /**
     * BFS solution with queue - iterate and process the tree level by level with BFS and for each
     * node that we process add a pointer to the next node in the queue except for the last node at
     * any level.
     *
     * TC: O(n)
     * SC: O(n) for queue
     */
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        Queue<Node> bfsQueue = new LinkedList<>();
        bfsQueue.add(root);

        while (!bfsQueue.isEmpty()) {
            int size = bfsQueue.size();

            for (int i = 0; i < size; i++) {
                Node curr = bfsQueue.poll();

                if (i != size - 1) {
                    curr.next = bfsQueue.peek();
                }

                if (curr.left != null) {
                    bfsQueue.add(curr.left);
                    bfsQueue.add(curr.right);
                }
            }
        }
        return root;
    }
}

// ------------------------- Solution 2 --------------------------------
class NextRightPointer2 {
    /**
     * BFS solution without extra space: We can eliminate the need of queue by processing children of current node by
     * attaching left chile next to right child and if current.next is available attach current node's right child to
     * current.next's left child (basically right child attaches to its immediate next cousin left on its parent)
     * We need another pointer to move to next level once one level is processed
     *
     * TC: O(n)
     * SC: O(1)
     */
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        Node curr = root;
        Node level = root;

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

// ------------------------- Solution 3 --------------------------------
class NextRightPointer3 {
    /**
     * Just like above approach, we can attach the current node's left.next to right and curr.right to
     * curr.next.left if curr.next is available. During this pre-order level ensures that when we go to next/below level
     * curr.next is available to attach curr.right to its cousin on curr.next.left. Note: only curr.right.next = curr.next.left
     * can be processed in in-order level without producing wrong result.
     *
     * TC: O(n)
     * Auxiliary SC: O(1)
     * Recursive stack SC: O(h) - height of the tree: max n for skewed tree or logn for perfect binary tree
     */
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        dfs(root);
        return root;
    }

    private void dfs(Node curr) {
        //base
        if (curr.left == null) {
            return;
        }

        //logic
        curr.left.next = curr.right;
        if (curr.next != null) {
            curr.right.next = curr.next.left;
        }

        dfs(curr.left);

        dfs(curr.right);
    }
}