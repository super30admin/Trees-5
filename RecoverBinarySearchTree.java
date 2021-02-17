//Problem 105 : Recover Binary Search Tree
//TC: O(N)
//SC: O(H), considering recursive stack;

/*
Steps : Use concept of inorder traversal, and then make prev to root. If prev is greater than the root, it means found the invalid node
*/

class Solution {

    class TreeNode{
        int val;
        TreeNode left,right;
    }

    TreeNode first,last,prev;
    boolean flag;
    public void recoverTree(TreeNode root) {
        
        if(root==null) return;
        
        helper(root);
        
        int temp = first.val;
        first.val = last.val;
        last.val = temp;
      
        
    }
    //inorder
    private void helper(TreeNode root){
        
        if(root==null) return;
        
        helper(root.left);
        
        if(prev!=null && prev.val>=root.val){//invalid bst, got the element
            
            if(!flag){
                first  = prev;
                last = root;//if both are adjacent
                flag = true;
            }else{
                last = root;
            }
            
        }
        
        prev = root;
            
        helper(root.right);    
    }
    
}