//Leetcode - 99
//TimeComplexity - O(N)
//Space Complexity - O(H)
public class RecoverBST{
    private class TreeNode {
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

    private TreeNode first;
    private TreeNode second;
    private TreeNode prev;
    public void recoverTree(TreeNode root) {
        if(root == null) return;
        inorder(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
    private void inorder(TreeNode root) {
        //base
        if(root == null) return;
        //logic
        inorder(root.left);
        if(prev != null && prev.val >= root.val) {
            //first breach
            if(first == null) {
                first = prev;
                second = root;
            } else {//2nd breach
                second = root;
            }
        }
        prev = root;
        inorder(root.right);
    }
}
