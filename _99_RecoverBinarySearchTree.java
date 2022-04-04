// Time Complexity : o(n) where n is number of nodes in tree
// Space Complexity : o(h) whre h is the height of tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

// Do an inorder traversal and find prev > curr node , keep two variable a, b and wehn you encounter prev > current second time
// then assigne curr to b.
class Solution {

    TreeNode a;
    TreeNode b;
    TreeNode prev;

    public void recoverTree(TreeNode root) {
        prev = new TreeNode(Integer.MIN_VALUE);
        inorder(root);
        int temp = a.val;
        a.val = b.val;
        b.val = temp;
    }

    public void inorder(TreeNode root ){

        if(root == null) return;

        inorder(root.left);

        if(prev.val > root.val){
            if(a == null){
                a = prev;
                b = root;
            }
            else{
                b = root;
            }
        }
        prev = root;
        inorder(root.right);

    }
}
