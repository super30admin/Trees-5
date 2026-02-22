// This problem is solved using Morris Traversal. We are using the right pointer of the predecessor to point to the current node. This way we can traverse the tree without using any extra space. 
// Time Complexity: O(n) where n is the number of nodes in the tree. We are visiting each node at most twice.
// Space Complexity: O(1) as we are not using any extra space for recursion or stack. 

/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    fun inorderTraversal(root: TreeNode?): List<Int> {
        val result = mutableListOf<Int>()
        if(root == null) return result
        var curr = root

        while(curr != null) {
            if(curr.left != null) {
                var pre = curr.left

                while(pre.right != null && pre.right != curr) {
                    pre = pre.right
                }
                if(pre.right == null) {
                    pre.right = curr
                    curr = curr.left
                } else {
                    pre.right = null
                    result.add(curr.`val`)
                    curr = curr.right
                }
            } else {
                result.add(curr.`val`)
                curr = curr.right
            }
        }
        return result
    }
}