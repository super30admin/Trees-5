// Time Complexity : o(n) 
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no




// Your code here along with comments explaining your approach

class Solution {
    TreeNode fmismatch;
    TreeNode smismatch;
    TreeNode prev;
    public void recoverTree(TreeNode root) {
        dfs(root);
        int temp=fmismatch.val;
        fmismatch.val = smismatch.val;
        smismatch.val = temp;
    }
    private void dfs(TreeNode root){
        if(root==null) return;
        
        dfs(root.left);
        if(prev!=null){
            if(prev.val>root.val){
                if(fmismatch==null){
                    fmismatch=prev;
                    //System.out.println(prev.val);
                }
                smismatch=root;
                    //System.out.println(prev.val);
                
            }
        }
        
        prev=root;
        //System.out.println(prev.val);
        dfs(root.right);
    }
}