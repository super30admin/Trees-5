
// Time - O(N)
// Space - O(N)



class Solution {
    TreeNode prev;
    TreeNode first;
    TreeNode last;
    boolean flag;
    public void recoverTree(TreeNode root) {

        if(root == null) return;
        inorder(root);
        int temp = first.val; // swap the value with temp val
        first.val = last.val;
        last.val = temp;

    }

    private void inorder(TreeNode root) { // inorder traversal

        if(root == null) return;

        inorder(root.left);

        if(prev != null && prev.val >= root.val) {
            if(!flag) {    // if flag is false then first breach
                first = prev;
                last = root;
                flag = true;
            }
            else { // second breach
                last = root;
                return;
            }
        }
        prev = root;

        inorder(root.right);

    }
}