// Time Complexity : O(n)
// Space Complexity : O(h), h = height of the recursive stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Notes : Perform an inorder traversal while maintainting a previous pointer and check if elements are in ascending order. If not swap the values in the nodes.

public class RecoverBinarySearchTree {
    TreeNode n1;
    TreeNode n1Next;
    TreeNode n2;
    
    TreeNode prev;
    
    public void recoverTree(TreeNode root) {
        if(root == null) return;

        inorder(root);
        
        int temp = n1.val;
        n1.val = n2.val;
        n2.val = temp;
    }
    
    private void inorder(TreeNode root){
        if(root == null) return;
        
        inorder(root.left);
        if(prev != null){
            if(prev.val > root.val){
                if(n1 == null){
                    n1 = prev;
                    n1Next = root;
                } else {
                    n2 = root;
                }
            }
        }
        
        if(n2 == null ){
            n2 = n1Next;
        }

        prev = root;
        
        inorder(root.right);
    }
}
