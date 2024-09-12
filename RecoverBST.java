Time Complexity - O(n)
Space Complexity - O(h)


class Solution {
    TreeNode first,second,prev;
    public void recoverTree(TreeNode root) {
        first = null;
        second = null;
        prev = new TreeNode(Integer.MIN_VALUE);
        
        if(root == null)return;
        inorder(root);
        swap(first,second);    
    }
    
    private void inorder(TreeNode root){
        if(root == null)return;
        inorder(root.left);
        
        //condition
        if(first == null && prev.val > root.val){
            first = prev;
        }
        
        if(first != null && prev.val > root.val){
            second = root;
        }
        prev = root;
        
        inorder(root.right);
    }
    
    private void swap(TreeNode a, TreeNode b){
        int temp = a.val;
        a.val = b.val;
        b.val = temp;
    }
    
    
}