// Time Complexity : O(N) where N is the number of nodes
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Scan the whole BST, find the anamolies and swap them using references.
public class RecoverBST {
    TreeNode prev;
    TreeNode first,second;
    boolean flag;
    public void recoverTree(TreeNode root) {
        helper(root);
        int temp= first.val;
        first.val=second.val;
        second.val=temp;
    }

    private void helper(TreeNode root){
        if(root==null) return;

        helper(root.left);
        if(prev!=null && prev.val>=root.val) {
            if(first==null) {
                first=prev;
                second= root;
                flag=true;
            }else{
                second= root;
                flag=false;
            }
        }
        prev=root;

        if(!(flag==false && first!=null && second!=null)){
            helper(root.right);
        }

    }
}
