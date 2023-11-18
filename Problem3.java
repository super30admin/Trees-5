//Time Complexity : O(n)
//Space Complexity : O(1)

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        morrisInorder(root);
    }
    private void morrisInorder(TreeNode root){
        TreeNode curr = root;
        while(curr!=null){
            if(curr.left == null){
                System.out.print(curr.val);

                curr = curr.right;
            }else{
                TreeNode pre = curr.left;
                while(pre.left != null && pre.right!=curr){
                    pre = pre.right;
                }
                if(pre.right == null){
                    pre.right = curr;
                    curr = curr.left;
                }else{
                    pre.right = null;
                    System.out.print(curr.val);
                    curr = curr.right;
                }
            }
        }
    }
}
