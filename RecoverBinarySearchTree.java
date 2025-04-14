/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

//Approach - Inorder traversal - check if the prev's val is greater than curr's vall
// if this is the first corruption - set first is prev, last is curr
// if this is the second corruption - set last to curr
//Time Complexity - worst case - O(N) - where N is number of nodes
//Space Complexity - O(1)
class Solution {
  TreeNode first, last, prev;
  boolean isFirst;
  public void recoverTree(TreeNode root) {
    if(root == null){
      return;
    }

    isFirst = false;
    inorder(root);
    int temp = first.val;
    first.val = last.val;
    last.val = temp;
  }

  public void inorder(TreeNode node){
    if(node == null){
      return;
    }
    inorder(node.left);

    if(prev != null && prev.val >= node.val){
      if(!isFirst){
        first = prev;
        last = node;
        isFirst = true;
      }
      else{
        last = node;
      }
    }
    prev = node;
    inorder(node.right);
  }
}
