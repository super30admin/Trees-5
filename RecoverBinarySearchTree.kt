// In this problem, we are given a bst where two nodes are not in the correct position. We solve this by doing an inorder traversal of the tree and keeping track of the previous node.
// If we find a node that is smaller than the previous node, then we know that the previous node is one of the nodes that is not in the correct position. We keep track of the first and seond
// nodes that are not in the correct position and then swap their values at the end.
// Time Complexity: O(n) where n is the number of nodes in the tree.
// Space Complexity: O(h) where h is the height of the tree. 


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
    var prev : TreeNode? = null
    var first : TreeNode? = null
    var second : TreeNode? = null
    fun recoverTree(root: TreeNode?) {
        if(root == null) return
        
        prev = null
        first = null
        second = null

        helper(root)
        if (first != null && second != null) {
            val a = first!!
            val b = second!!
            val temp = a.`val`
            a.`val` = b.`val`
            b.`val` = temp
        }

    }

    fun helper(root: TreeNode?){
        if(root == null) return

        helper(root.left)
        val p = prev
        if(p != null && p.`val`>= root.`val`) {
            if(first == null) {
                first = p
                second = root
            } else {
                second = root
            }
        }

        prev = root
        helper(root.right)
    }
}