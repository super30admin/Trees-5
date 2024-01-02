/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

// Time Complexity: O(n)
// Space Complexity: O(h)
// Iterative Approach
class Solution {
    TreeNode first;
    TreeNode second;
    TreeNode prev;
    public void recoverTree(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while(!stack.isEmpty() || root != null){
            while(root != null){
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            if(prev != null && prev.val >= root.val){
                if(first == null) first = prev;
                second = root;

            }
            prev = root;
            root = root.right;
        }
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
}


// Time Complexity: O(n)
// Space Complexity: O(h)
// Recursive Approach
class Solution {
    TreeNode prev = null;
    TreeNode first = null;
    TreeNode second = null;

    public void recoverTree(TreeNode root) {

        if(root == null) return;
        inorder(root);
        int t = first.val;
        first.val = second.val;
        second.val = t;
        return;
        
    }

    public void inorder(TreeNode root){
        if(root != null){
            inorder(root.left);
            if(prev != null &&  root.val < prev.val){
                second = root;
                if(first == null)
                    first = prev;
                else 
                    return;
            }
            prev = root;
            inorder(root.right);
        }
        return;
    }
}