//The idea here is to do an inorder traversal of the BST and check if all the nodes are sorted using two pointers
//Whenever we encounter the first breach, we put those values in two temporary nodes, first and second.
//If we encounter a second breach, we only update the second node.
//When we traverse the tree, we swap the two values in nodes first and second.
//Time Complexity: O(n)
//Space Complexity: O(h) recursive stack space
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

class Solution {
    TreeNode prev;
    TreeNode first;
    TreeNode second;
    public void recoverTree(TreeNode root) {
        if(root == null) return;
        inorder(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void inorder(TreeNode root){
        if(root == null){
            return;
        }

        //logic
        inorder(root.left);
        if(prev!= null && prev.val >= root.val){
            if(first!= null){
                second = root;
            } else{
                first = prev;
                second = root;
            }
        }
        prev = root;
        inorder(root.right);
    }
}