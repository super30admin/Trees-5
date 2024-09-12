//time complexity-O(n)
//space complexity-O(depth)
//Ran on leetcode-Yes
//Solution with comments-
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
        if(root==null)
            return ;
        
        TreeNode prev =null;
        TreeNode x = null;
        TreeNode y = null;
        
        Stack<TreeNode> st = new Stack<>();//Inorder traversal
        
        while(!st.isEmpty() || root!=null){
            while(root!=null){
                st.push(root);
                root=root.left;
            }
            
            TreeNode top=st.pop();
            if(prev!=null && prev.val>top.val){//first element will be always greater and seconf element will always be less.
                y=top;
                if(x!=null)
                    break;
                x=prev;
            }            
            prev=top;
            root=top.right;
        }
        swap(x,y);
    }
    
    public void swap(TreeNode a, TreeNode b){
        int temp = a.val;
        a.val=b.val;
        b.val=temp;
        return;
    }
}
