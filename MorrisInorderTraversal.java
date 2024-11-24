class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        TreeNode curr =root;
        List<Integer> res=new ArrayList<>();
        while(curr!=null){
            if(curr.left== null){
                res.add(curr.val);
                curr=curr.right;
            }else{
                TreeNode pre=curr.left;
                while(pre.right!=null && pre.right!=curr){
                    pre=pre.right;
                }
                if(pre.right==null){
                    pre.right=curr;
                    curr=curr.left;
                }else{
                    pre.right=null;
                    res.add(curr.val);
                    curr=curr.right;
                }
            }
        }
        
        return res;
    }
}