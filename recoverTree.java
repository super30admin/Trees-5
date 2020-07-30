// Time Complexity : O(n) n is number of nodes
// Space Complexity :O(h) height of recursive stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {
    TreeNode first = null, second = null;
    TreeNode pred = null;
    public void recoverTree(TreeNode root) {
        
        findNodes(root);
        int temp = first.val;
        first.val = second.val;
        second.val=temp;
        
    }
    
    private void findNodes(TreeNode node){
        if(node == null) return;
        
        findNodes(node.left);
        if(pred!=null && node.val<pred.val){
            first = node;
            if(second==null)
                second = pred;
            else 
                return;
        }
        pred = node;
        findNodes(node.right);
    }
}