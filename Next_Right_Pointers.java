// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public Node connect(Node root) {
        helper(root);
        return root;
    }
    
    public void helper(Node root){
        if(root==null) return;
        
        if(root.left!=null){
            root.left.next=root.right;
        }
        
        if(root.next!=null && root.right!=null){
            root.right.next=root.next.left;
        }
        
        helper(root.left);
        helper(root.right);
    }
}