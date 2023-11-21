
// Time Complexity :O(n)
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> res = new ArrayList<Integer>();
    if(root == null) return res;
    TreeNode pre = null;
    while(root != null){
       if(root.left == null) {
           res.add(root.val);
           root = root.right;
       } 
       else{
           pre = root.left;
           while(pre.right != null && pre.right != root){
               pre = pre.right;
           }
               if(pre.right == null){
                  pre.right = root;
                  root = root.left;
                  
              } else{
                  pre.right = null;
                  res.add(root.val);
                  root = root.right;
                  
              }
                      
           }    
    }
    return res;

    }
}
