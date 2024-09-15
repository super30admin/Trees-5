//Approach: Implement inorder traversal to find the 2 misplaced values. 
// Time: O(n) as we do inorder traversal
// Space: O(n) - O(h) average case where h is height of tree

class TreeNode {     
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
 
public class RecoverBST {
    TreeNode first;
    TreeNode second;
    TreeNode prev = new TreeNode(Integer.MIN_VALUE);
    public void recoverTree(TreeNode root) {

        helper(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
        
    }
    private void helper(TreeNode root){
        if (root == null) return;

        helper(root.left);

        if (first == null && prev.val > root.val){
            first = prev;
        }  
        if (first != null && prev.val > root.val){
            second = root;
        }
        prev = root;
        helper(root.right);
    }
}