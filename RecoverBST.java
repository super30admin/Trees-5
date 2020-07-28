/**
 * Algo: # Inorder traversal, at every node keep track of theprevious node val, if curr val is smaller than prev then store the first and last
 *         # if we find another such breach then change the alst ptr (sometimes the breach will be adjacent and sometimes not)
 *
 *         TIme: O(n) n-nodes
 *         Space: O(h) h-height of the tree
 */
class Solution {

    TreeNode first; TreeNode last;

    TreeNode prev; boolean flag;

    public void recoverTree(TreeNode root) {

        if(root == null) return;

        inorder(root);

        int temp = last.val;

        last.val = first.val;

        first.val = temp;



    }

    private void inorder(TreeNode root){

        if(root == null) return;

        inorder(root.left);

        //root = st.pop();

        if(prev != null && root.val < prev.val){

            if(!flag){

                flag = true;

                first = prev; last = root;

            } else {

                last = root;

            }

        }

        prev = root;

        inorder(root.right);

    }

}