//Time Complexity : O(n)
//Space Complexity : O(h)

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
        TreeNode prev = null;
        TreeNode ptr1 =null;
        TreeNode ptr2=null;
        
        while(root!=null || !st.isEmpty()){
            
            while(root!=null){
                st.push(root);
                root = root.left;
            }
            
            root=st.pop();
            if(prev!=null && prev.val > root.val){
                ptr1=root;
                ptr2=prev;
            }else{
                prev=root;
                
            }
            root = root.right;
        }
       int temp = ptr1.val;
       ptr1.val = ptr2.val;
       ptr2.val = temp;
    }
}