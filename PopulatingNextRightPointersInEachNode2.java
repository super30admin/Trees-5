/*
 Algorithm: Iterative level-wise connection using already established next pointers (constant extra space)

 Approach:
 - This assumes a perfect binary tree.
 - Use pointers `current` to iterate across a level and `level` to mark the start of the current level.
 - For each node at the level, connect current.left.next = current.right and current.right.next = current.next.left when current.next exists.
 - When current reaches end of level, move down to level.left and repeat.

 Time Complexity: O(n) where n is number of nodes (each connection set once).
 Space Complexity: O(1) extra space (only a few pointers) — excluding recursion/stack.

 LeetCode: https://leetcode.com/problems/populating-next-right-pointers-in-each-node/ (116)
*/

public class PopulatingNextRightPointersInEachNode2 {

    public Node connect(Node root) {
        Node current = root;
        Node level = root;
        while (current != null && current.left != null) {
            current.left.next = current.right;
            if (current.next != null) {
                current.right.next = current.next.left;
            }

            if (current.next != null) {
                current = current.next;
            } else {
                current = level.left;
                level = level.left;
            }
        }
        return root;
    }
}
