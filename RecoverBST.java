// Time Complexity : O(n)
// Space Complexity : O(h) ; h - height of binary tree
// Did this code successfully run on Leetcode : Yes

public class RecoverBST {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

    TreeNode first;
    TreeNode second;
    TreeNode prev;
    public void recoverTree(TreeNode root) {
        if(root == null) return;
        inorder_helper(root);

        //swap values of violated nodes
        int temp = first.val;
        first.val = second.val;
        second.val = temp;

    }

    private void inorder_helper(TreeNode root){
        //base
        if(root == null) return;

        //logic
        inorder_helper(root.left);
        //check for violations
        if(prev != null && prev.val >= root.val){
            //first violation
            if(first == null && second == null ){
                first = prev;
                second = root;
            }else{
                second = root;
            }
        }
        prev = root;
        inorder_helper(root.right);
    }
}
