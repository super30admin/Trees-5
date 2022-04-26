public class RecoverBST {
  /**
   * Time Complexity: O(n)
   * 
   * Space complexity: O(height)
   * 
   * Were you able to solve this on leetcode? Yes
   * 
   */
  TreeNode first;
  TreeNode second;
  TreeNode prev;
  
  public void recoverTree(TreeNode root) {
      inorder(root);
      
      int temp = first.val;
      first.val = second.val;
      second.val = temp;
      
  }
  
  private void inorder(TreeNode root){
      // base case
      if(root == null) { return; }
      
      inorder(root.left);
      if(prev != null && prev.val >= root.val){
          if(first == null && second == null){
              first = prev;
              second = root;
          } else {
              second = root;
          }
      }
      
      prev = root;
      inorder(root.right);
  } 
}
