// Time Complexity : O(n)
// Space Complexity : O(1)

class Solution {
    public void morrisInorderTraversal(TreeNode root) {

        TreeNode curr = root;
        while(curr != null){
            if(curr.left == null){
                System.out.println(curr.val);
                curr = curr.right;
            }else{
                TreeNode pre = curr.left;
                while(pre.right != null && pre.right != curr){
                    pre = pre.right;
                }

                if(pre.right == null){
                    pre.right = curr;
                    curr = curr.left;
                }else{
                    pre.right = null;
                    System.out.println(curr.val);
                    curr = curr.right;
                }
            }
        }

    }
}