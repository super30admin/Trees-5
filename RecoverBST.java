// Time Complexity : O(n) n to traverse all nodes to find the swapped nodes
// Space Complexity : O(h) For recursion stack, h is the height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

class RecoverBST {
    TreeNode first;
    TreeNode second;
    TreeNode prev;
    public void recoverTree(TreeNode root) {
        if(root == null) return;
        inorder(root);
        int temp = second.val;
        second.val = first.val;
        first.val = temp;
    }

    private void inorder(TreeNode root){
        if(root==null) return;

        inorder(root.left);
        if(prev!=null){
            if(prev.val>root.val){
                //BST breach
                //check if first breach!!
                if(first==null){
                    first = prev;
                    second = root;
                }
                else{
                    //second breach
                    second = root;
                }
            }
        }
        prev = root;
        inorder(root.right);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}