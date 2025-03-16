package recoverBST;



//tc: O(n), where is the no of node
//sc: O(h), height of the tree


class InorderIterative {
    TreeNode prev;
    TreeNode first;
    TreeNode second;
    public void recoverTree(TreeNode root) {

        if(root == null) {
            return;
        }

        inorder(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void inorder(TreeNode root)
    {
        // base
        if(root == null) {
            return;
        }

        // logic
        inorder(root.left);

        //  breach
        if(prev != null && prev.val >= root.val) {

            // first breach
            if(first == null) {
                first = prev;
                second = root;
            }
            // second breach
            else {
                second = root;
            }
        }
        // move forward
        prev = root;

        inorder(root.right);
    }
}