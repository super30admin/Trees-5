package Trees5;

/*
    -------------------------------------------------------------------------------------------------------
    Time complexity : o(N) 
    space complexity: o(1)
    Did this code run successfully in leetcode : yes
    problems faces : no
    Approach : There will be two breaches of binary tree .  
    create first and last variables where will store first and last breaches.
    Do dfs and search for the root.val where prev.val >= root.val. if found make the first == prev and flag=true(this is first breach).
    keep doing dfs untlll the next breach is found. 
    
        
    */
public class recoverBinaryTree {

    TreeNode prev = null;
    TreeNode first = null;
    TreeNode last = null;
    boolean flag;
    boolean secondFlag;

    public void recoverTree(TreeNode root) {
        if (root == null)
            return;
        inorder(root);

        int tmp = first.val;
        first.val = last.val;
        last.val = tmp;

    }

    private void inorder(TreeNode root) {

        if (root == null)
            return;
        inorder(root.left);

        if (prev != null && prev.val >= root.val) {
            if (!flag) {
                first = prev;
                last = root;
                flag = true;
            } else {
                last = root;
                secondFlag = true;
            }

        }

        prev = root;
        if (!secondFlag) {
            inorder(root.right);
        }

    }

}
