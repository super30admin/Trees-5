import com.sun.source.tree.Tree;
//Time Complexity: O(n)
// Space Complexity: O(h)

public class problem2 {

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
  TreeNode first, second, prev;
      public void recoverTree(TreeNode root) {
          helper(root);
          int temp= first.val;
          first.val = second.val;
          second.val = temp;

      }
      private void helper(TreeNode root) {
          if (root == null) return;
          helper(root.left);
          if (prev != null && prev.val > root.val) {
              if (first==null)
              {
                  first = prev;
                  second = root;
              }
              else {
                  second=root;
              }
          }
          prev= root;
          helper(root.right);

      }
}
