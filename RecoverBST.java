// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : none


// Your code here along with comments explaining your approach

class RecoverBST {
    Stack<TreeNode> st;
    TreeNode prev;
    TreeNode first;
    TreeNode second;
    public void recoverTree(TreeNode root) {
        if(root==null)
            return;
        inorder(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
        
    }
    private void inorder(TreeNode root){
        if(root!=null){
            inorder(root.left);
            if(prev!=null && root.val <= prev.val){
                //first
                if(first==null){
                    first= prev;
                    second = root;
                }
                else{
                    second = root;
                }
            }
            prev=root;

            inorder(root.right);
        }
    }
}