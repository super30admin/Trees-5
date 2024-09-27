package s30.trees.trees5;

import s30.trees.TreeNode;


//Algo: use BST feature of sorted order, we know exactly two nodes are replaced.
// We can also implement using an array

//TC: O(n)
//SC: O(h)
public class RecoverBinarySearchTree {

    TreeNode prev, first, second;
    public void recoverTree(TreeNode root) {

        first= null;
        second = null;
        prev = null;

        inorderTraverse(root);

        int temp = first.val;
        first.val = second.val;
        second.val = temp;


    }


    private void inorderTraverse(TreeNode node){
        if(node == null) return;

        inorderTraverse(node.left);

        if(prev != null && prev.val > node.val){
            if(first == null){
                first = prev;
            }
            second = node;
        }

        prev = node;

        inorderTraverse(node.right);
    }
    public static void main(String[] args) {

    }
}
