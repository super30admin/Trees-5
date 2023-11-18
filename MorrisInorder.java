// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : none


// Your code here along with comments explaining your approach

class MorrisInorder {
    List<Integer> res;
    public List<Integer> inorderTraversal(TreeNode root) {
        res = new ArrayList();
        morrisInorder(root);
        return res;
    }
    private void morrisInorder(TreeNode root){
        TreeNode curr = root;
        while(curr!=null){
            if(curr.left==null){
                res.add(curr.val);
                curr = curr.right;
            }else{
                TreeNode pre = curr.left;
                while(pre!=null && pre.right!=null && pre.right!=curr){
                    pre = pre.right;
                }
                if(pre!=null && pre.right == null){
                    pre.right = curr;
                    curr = curr.left;
                }
                else{
                    if(pre!=null)
                        pre.right = null;
                    res.add(curr.val);
                    curr = curr.right;
                }
            }
        }
    }
}