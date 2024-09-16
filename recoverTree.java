// Time Complexity : O(n)
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach
// use morris preorder traversal and compare current node to prev node
// preorder of bst is sorted
class Solution {
    public void recoverTree(TreeNode root) {
        
        TreeNode a=null, b=null;
        TreeNode curr, prev=null;
        
        while(root!=null) {
            
            if(root.left!=null) {
                
                curr = root.left;
                while(curr.right!=null && curr.right!=root){
                    curr=curr.right;
                }
                if(curr.right==null) {
                    curr.right=root;
                    root=root.left;
                } else {
                    if(prev!=null && root.val<prev.val) {
                        a = root;
                        if(b==null) b = prev;
                    }
                    prev = root;
                    curr.right=null;
                    root = root.right;
                }
                
            } else {
                
                if(prev!=null && root.val<prev.val) {
                    a = root;
                    if(b==null) b = prev;
                }
                prev = root;
                root=root.right;
            }
            
        }
        swap(a,b);
    }
    
    public void swap(TreeNode a, TreeNode b) {
        int tmp = a.val;
        a.val = b.val;
        b.val = tmp;
    }
}
