// Time Complexity : O(n),number of nodes.
// Space Complexity : O(h),  recursive stack space.
//where h = height of the tree (max recursion calls at one point)
// Did this code successfully run on Leetcode : yes
// Three line explanation of solution in plain english : Do an inorder traversal and find breach by keeping a previous pointer. Find first and second breach and swap the values.


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
class Solution {
    TreeNode first;
    TreeNode second;
    TreeNode prev;
    
    public void recoverTree(TreeNode root) {
        if(root == null) return;

        inorder(root);  
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void inorder(TreeNode root){
        if(root == null) return;

        inorder(root.left);
        //find breach
        if(prev != null && prev.val >= root.val){
            if(first == null){
                first = prev; 
            }
            second = root;
        }

        prev = root;
        inorder(root.right);

    }
}

// Iterative inorder stack

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
class Solution {
    TreeNode first;
    TreeNode second;
    TreeNode prev;
    
    public void recoverTree(TreeNode root) {
        if(root == null) return;

        inorder(root);  
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void inorder(TreeNode root){
        Stack<TreeNode> st = new Stack<>();
        
        while(root != null || !st.isEmpty()){
            //move left
            while(root != null){
                st.push(root);
                root = root.left;
            }

            root = st.pop();
            //find breach
            if(prev != null && prev.val >= root.val){
                if(first == null){
                    first = prev; 
                }
                second = root;
            }

            prev = root;
            root = root.right;
        }

    }
}