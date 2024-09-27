// Time Complexity : O(n)
// Space Complexity :O(h) h-> height of the tree
class Solution {
    TreeNode first, second,prev, current;
    
    public void recoverTree(TreeNode root) {
        if(root==null) return;
        dfs(root);
        
        int temp=first.val;
        first.val=second.val;
        second.val=temp;
    }
    
    private void dfs(TreeNode root){
        //base case
        if(root==null) return;
        
        //logic
        dfs(root.left);
        
        if(prev!=null && root.val < prev.val){
            if(first==null){
                first=prev;
            }
            second=root;
        }
        prev=root;
        
        dfs(root.right);
        
        
    }
}