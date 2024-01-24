
// TC : O(n)
// SC : O(1)

package S30_Codes.Trees_5;

// Definition for a binary tree node.
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

class RecoverBinarySearchTree {
    TreeNode first, second;
    TreeNode prev;

    public void recoverTree(TreeNode root) {
        inorder(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void inorder(TreeNode node){
        // base
        if(node == null) return;

        // logic
        inorder(node.left);
        if(prev != null && prev.val >= node.val){
            if(first == null){
                first = prev;
                second = node;
            }
            else{
                second = node;
            }
        }

        prev = node;
        inorder(node.right);
    }
}
