// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

public class RecoverBST {
    class Solution {
        TreeNode first;
        TreeNode second;
        TreeNode prev;
        public void recoverTree(TreeNode root) {
            if(root == null)
                return;

            this.first = null;
            this.second = null;
            this.prev = null;

            inorder(root);

            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }

        private void inorder(TreeNode root){
            //base
            if(root == null)
                return;

            //logic
            inorder(root.left);

            if(prev != null && root.val < prev.val){
                //first breach
                if(first == null){
                    first = prev;
                    second = root;
                }
                else{
                    //second breach
                    second = root;
                }
            }
            prev = root;

            inorder(root.right);
        }
    }
}
