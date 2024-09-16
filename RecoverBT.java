// Using prev pointer : Similar to Validate BST

class Solution {
    TreeNode prev = null;
    TreeNode first, second;
    
    public void recoverTree(TreeNode root) {
        if(root == null)
            return;
        inorder(root);
        
        //swap the mismatched values at the node
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
    
    public void inorder(TreeNode root){
        if(root == null)
            return;
        
        inorder(root.left);
        
        //we make the second as root as sometimes the second no mismatched is root of the first mismatched no and does not get captured.
        if(prev != null && prev.val >= root.val){
            if(first == null){
                first = prev;
                second = root;
            }
            else
                second = root;
        }
        prev = root;
        
        inorder(root.right);
    }
}

//Time Complexity :O(n)
//Space Complexity :O(1)