/*
 Algorithm: BFS (level-order) traversal using a queue

 Approach:
 - Use a queue to perform level-order traversal.
 - For each level, iterate through nodes and connect node.next to the next node in the queue (peek) when not at end of level.
 - Enqueue children (left and right) for the next level if they are non-null.
 - This sets the next pointers level by level.

 Time Complexity: O(n) where n is number of nodes (each node enqueued/dequeued once).
 Space Complexity: O(w) where w is maximum width of tree (queue size) — worst-case O(n) for a full level.

 LeetCode: https://leetcode.com/problems/populating-next-right-pointers-in-each-node/ (116)
*/

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNode {

    public Node connect(Node root) {
        if(root == null) return root;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (node == null) continue; // defensive: skip if poll returned null
                if (i < size - 1) {
                    node.next = queue.peek();
                }
                // enqueue children defensively to avoid NPEs in non-perfect trees
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return root;
    }
}
