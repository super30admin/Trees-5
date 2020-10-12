// Time Complexity : O(V+E)
// Space Complexity : O(max depth of tree), in stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//inorder traversal of BST gives sorted order
//no prev element in the inorder is greater than the next/popped element
//whenever the condition is broke, we shall keep track of popped ele as x and the first prev ele as y
//we can just swap the last x and y to recover the BST.

class Solution {
    public void recoverTree(TreeNode root) {
        if(root==null) return;
        TreeNode prev=null;
        TreeNode x=null, y=null;
        Stack<TreeNode> res=new Stack<>();
        while(!res.isEmpty()||root!=null){
            while(root!=null){
            res.push(root);
            root=root.left;
            }
        TreeNode popped=res.pop();
        if(prev!=null&&prev.val>popped.val){
            x=popped;
            if(y==null){
                y=prev;
            }    
            else{
                break;
            }
        }
        prev=popped;
        root=popped.right;
       }
        swap(x,y);
        
    }
    private void swap(TreeNode x, TreeNode y){
        int temp=y.val;
        y.val=x.val;
        x.val=temp;
    }
}