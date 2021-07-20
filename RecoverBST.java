/*SC - O(N) TC O(N)
 * */


class Solution {
    boolean flag ;
    TreeNode first;
    TreeNode last;
    TreeNode prev;
    public void recoverTree(TreeNode root) {
        inorder(root);
        // swap first and last
        int temp = first.val;
        first.val = last.val;
        last.val= temp;

    }

    public void inorder(TreeNode root){
        if (root == null) return;
        inorder(root.left);
        // st.pop()
        // data
        if (prev != null && prev.val > root.val){
            if(!flag){
                first = prev;
                last = root;
                flag = true;
            } else {
                // second breach
                last = root;
                return;
            }
        }
        prev =  root;
        //right

        inorder(root.right);
    }

}
