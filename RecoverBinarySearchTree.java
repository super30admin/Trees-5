// Time Complexity : O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
/* take a prev node, in starting it should be null 
//Using inOrder traversal check if prev!= null && prev.val >= root.val if so  then store first violence first = previous and second = root.
take a flag to check if it is first time violence then save first = prev, second = root , if it second violence then save second = root. 
set prev = root.
*/

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
class Solution {
    TreeNode first;
    TreeNode second;
    TreeNode previous;
    boolean flag;
    public void recoverTree(TreeNode root) {
        if(root == null) return;
        flag = true;
        dfs( root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp; 
     
    }
    
   public void  dfs(TreeNode root) 
   {
       if(root == null)
           return;
       
       dfs(root.left );
       if(previous != null && previous.val >= root.val)
       {
              if(flag)
              { 
                  first = previous;
                  second = root;
                  flag = false; 
              }
              else
              {
                 
                second = root;
              }
           
       }
         previous = root;
         dfs(root.right )  ;
     
       
   }
}