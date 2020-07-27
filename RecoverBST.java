// Time Complexity: O(N) n-> number of nodes in the tree
// Space Complexity: O(H) Size of recursive stack

class Solution {
    TreeNode first; TreeNode last;
    TreeNode prev; boolean flag; // flag to check if it's a first breach or second breach
    public void recoverTree(TreeNode root) {
        inorder(root);
        int temp = first.val;
        first.val = last.val;
        last.val = temp;
    }

    private void inorder(TreeNode root){
        // base case
        if(root == null) return;
        // logic
        inorder(root.left);
        // root = st.pop()
        if(prev != null && prev.val >= root.val){ // breach
            // check if first breach or not
            if(!flag){  // first breach
                first = prev;
                last = root;
                flag = true;
            }
            else {
                last = root;  //reset last to new root, 2nd breach
            }
        }
        prev = root;
        inorder(root.right);

    }
}
