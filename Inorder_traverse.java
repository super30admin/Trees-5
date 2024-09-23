//Time Complexity : O(n)
// Space Complexity : O(h)

import java.util.ArrayList;
import java.util.List;
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
 

class Solution {
    public List<Integer> inorderTravers(TreeNode root,List<Integer> l ) 
    {
        if(root==null)
        {
            return l;
        }
        inorderTravers( root.left, l ) ;
        l.add(root.val);
        inorderTravers( root.right, l ) ;
        return l;
    }
    public List<Integer> inorderTraversal(TreeNode root) 
    {   List<Integer> l= new ArrayList<>();
        l=inorderTravers( root, l ) ;
        return l;
    }
}