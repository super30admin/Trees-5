// Time Complexity : O(N)
// Space Complexity : O(H) using queue, O(1) + recursion stack using recursion.
// Did this code successfully run on Leetcode : Yes.
// Any problem you faced while coding this : Nope.


// Your code here along with comments explaining your approach
class RecoverBinarySearchTree {
    boolean firstBreachFound = false, secondBreachFound = false;
    TreeNode prev = null, firstBreachNode = null, secondBreachNode = null;
    public void recoverTree(TreeNode root) {
        inorder(root);
        int temp = firstBreachNode.val;
        firstBreachNode.val = secondBreachNode.val;
        secondBreachNode.val = temp;
       
    }
    public void inorder(TreeNode root){
        if(null == root){return;}
        inorder(root.left);
        if(null != prev && !firstBreachFound && prev.val > root.val){
            firstBreachFound = true;
            firstBreachNode = prev;
            secondBreachNode = root;
        }else if(firstBreachFound && prev.val > root.val){
            secondBreachNode = root;
            return;
        }
        prev = root;
        inorder(root.right);
    }
}
