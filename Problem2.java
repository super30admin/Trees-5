//Time Complexity: O(N)
//Space Complexity: O(1)

//we use prev pointer to keep track of the previous node in inorder traversal
//we use first and second pointers to keep track of the two nodes that are swapped
//we perform an inorder traversal of the tree and whenever we find a violation of the BST property
//we update the first and second pointers accordingly
//finally we swap the values of the first and second nodes to recover the tree


class Solution {
    TreeNode prev,first,second;
    public void recoverTree(TreeNode root) {
        helper(root);
        int temp=first.val;
        first.val=second.val;
        second.val=temp;
    }
    void helper(TreeNode root){
        if(root==null) return;
        helper(root.left);

        if(prev!=null &&prev.val>=root.val){
            if(first==null){
                first=prev;
                second=root;
            }else
                second=root;

        }
        prev=root;

        helper(root.right);
    }
}