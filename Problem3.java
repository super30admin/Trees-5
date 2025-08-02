// https://leetcode.com/problems/binary-tree-inorder-traversal/

// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach



class Solution {
    List<Integer> result;
    public List<Integer> inorderTraversal(TreeNode root) {
            this.result = new ArrayList<Integer>();
            morrisInorder(root);
            return result;
    }
    private void morrisInorder(TreeNode root){
        TreeNode curr = root;
        while(curr!=null){
            if(curr.left==null) {
                result.add(curr.val);
                curr=curr.right;
            }else{
                TreeNode pre = curr.left;
                while(pre.right!=null && pre.right!=curr) pre=pre.right;
                if(pre.right==null) {
                    pre.right=curr;
                    curr=curr.left;
                }
                else{
                    pre.right=null;
                    result.add(curr.val);
                    curr=curr.right;
                }
            }
        }
    }
}