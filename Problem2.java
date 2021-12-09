//99. Recover Binary Search Tree
// time - O(h)
// space - O(n)
class Solution {
    
    TreeNode first;
    TreeNode second;
    TreeNode prev = null;
    boolean flag = false;
    
    public void recoverTree(TreeNode root) {
        inorder(root);
        
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
    
    private void inorder(TreeNode root){
        
        if(root == null){
            return;
        }
        
        inorder(root.left);
        
        if(prev != null && prev.val > root.val){
            if(flag == false){
                first = prev;
                second = root;
                flag = true;
            }else{
                second = root;
            }
        }
        
        prev = root;
        
        inorder(root.right);
    }
}