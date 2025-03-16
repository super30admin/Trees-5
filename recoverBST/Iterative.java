package recoverBST;

//tc: O(n), where is the no of node
//sc: O(h), height of the tree

class Iterative {

    public void recoverTree(TreeNode root) {

        if(root == null) {
            return;
        }

        TreeNode prev = null;
        TreeNode first = null;
        TreeNode second = null;

        Stack<TreeNode> st = new Stack();

        while(!st.isEmpty() || root != null) {
            while(root != null) {
                st.push(root);
                root = root.left;
            }

            root = st.pop();

            //  check for breach
            if(prev != null && prev.val >= root.val ) {

                // first breach
                if(first == null) {
                    first = prev;
                    second = root;
                }
                // econd rbeach
                else {
                    second = root;
                }
            }

            prev = root;
            root = root.right;
        }

        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
}