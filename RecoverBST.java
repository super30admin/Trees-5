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
// Approach : DFS with iterative solution using own stack
// Time : O(n)
// Space : O(h) // stack length

class Solution {
    TreeNode first,second;
    TreeNode prev;
    public void recoverTree(TreeNode root) {
        Stack<TreeNode> stk = new Stack<>();
        while(!stk.isEmpty() || root!=null){
            while(root!=null){
                stk.push(root);
                root = root.left;
            }
            root = stk.pop();
            // identify the breach
            if(prev!=null && prev.val>=root.val){
                if(first ==null){ // first breach
                    first = prev;
                    second = root;
                } else{ // second breach
                    second = root;
                }
            }
            prev=root;
            root = root.right;
        }
        // swapping
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
}

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
// Approach : DFS - In Order traversal (using prev) and  two pointers to store the breach.
// Time : O(n) // visiting all the nodes
// Space : O(h) // recursive stack.
class Solution {
    TreeNode first, second;
    TreeNode prev;
    public void recoverTree(TreeNode root) {
        helper(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
    private void helper(TreeNode root){
        // basic
        if(root == null) return;
        
        // logic
        helper(root.left);
        if(prev !=null && prev.val>=root.val){
            // How to check if it is first breach or second breach
            if(first == null){
                first = prev;
                second = root;
            }else{
                second = root;
            }

        }
        prev=root;
        helper(root.right);
    }
}