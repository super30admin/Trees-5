// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
public void morris(TreeNode root){
    TreeNode curr = root;
    while(curr!=null){
        if(curr.left == null){
            System.out.println(curr.val);
            curr = curr.right;
        }
        TreeNode prev = curr.left;
        while(prev.right!=null && prev.right!=curr)
            prev = prev.right;
        if(prev.right == curr){
            System.out.println(curr.val);
            prev.right = null;
        }
        else{
            prev.right = curr;
            curr = curr.right;
        }
    }
}