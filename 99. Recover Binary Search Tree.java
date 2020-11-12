class Solution {//Time of O(n) and space of O(1)
    TreeNode first,second , prev ;
    public void recoverTree(TreeNode root) {
        helper(root);
        if(first != null && second != null){
            int temp  = first.val ;
            first.val = second.val ;
            second.val = temp ;
        }
    }
    public void helper(TreeNode root){
        if(root != null){
            helper(root.left);
            //Process Root
            if(prev != null && root.val < prev.val){
                if(first == null){
                    first = prev ;
                    second = root ;
                }else{
                    second = root ;
                    
                }
            }
            prev = root ;
            helper(root.right);
        }
    }
}