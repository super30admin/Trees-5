//Time complexity: O(N), where N is the number of nodes in tree.
//Space complexity: O(1)

import java.util.*;

//  Definition for a binary tree node.
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

class Solution2 {
    public void recoverTree(TreeNode root) {
        if(root == null) return;
        
        TreeNode first = null;
        TreeNode second = null; 
        
        TreeNode prev = null; 
        Stack<TreeNode> stack = new Stack<>();
        while(!stack.isEmpty() || root != null) {
            while(root!=null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop(); 
            if(prev != null && prev.val > root.val) {
                second = root; 
                if(first == null) first = prev;
                else break;
            }
            prev = root;
            root = root.right;
        }
        
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
}