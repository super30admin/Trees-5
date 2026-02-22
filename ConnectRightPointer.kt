// In this problem, we add next pointer to the right of the current node. We start by keeping track of the level and then we connect the left and right child of the current node.
// We also connect the right child of the current node to the left child of the next node if the next node is not null.
// Time Complexity: O(n) where n is the number of nodes in the tree.
// Space Complexity: O(1) as we are not using any extra space for recursion or stack.

/**
 * Definition for a Node.
 * class Node(var `val`: Int) {
 *     var left: Node? = null
 *     var right: Node? = null
 *     var next: Node? = null
 * }
 */

class Solution {
    fun connect(root: Node?): Node? {
        if (root == null) return null
        var level = root

        while(level!!.left != null) {
            var curr = level
            while(curr != null) {
                curr.left?.next = curr.right

                if(curr.next != null){
                    curr.right?.next = curr.next?.left
                }

                curr = curr.next
            }

            level = level.left
        }

        return root
    }
}