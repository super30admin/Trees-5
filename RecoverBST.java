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
    public void recoverTree(TreeNode root) {
        Stack<TreeNode> st = new Stack();
        boolean flag = false; TreeNode prev = null;
        TreeNode first = null; TreeNode last = null;
        
        if(root == null) return;
        while(!st.isEmpty() || root != null){
            while(root!=null){
                st.push(root);
                root = root.left;
            }
            root = st.pop();
            if(prev != null && prev.val >= root.val){
                if(!flag){
                    first = prev;
                    last = root;
                    flag = true;
                }
                else{
                    last = root;
                }
            }
            prev = root;
            root = root.right;
        }
        
        if(first != null && last!=null){
                int temp = last.val;
                last.val = first.val;
                first.val = temp;
            }
    }
}
