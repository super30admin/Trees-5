package Trees5;

public class question105_RecoverBinarySearchTree {
    /* Created by palak on 7/29/2021 */
    /** Definition for a binary tree node. */
    public class TreeNode {
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

    /**
     Maintain a flag to check the number of breaches.
     ex: 1,5,7,10,15,12,18,20,25,30,35,40,50
     Only One Breach here:
     First = prev = 10
     Last = root = 12
     Now swap First and Last
     ex: 1,5,7,10,30,18,20,25,15,30,35,40,50
     There will be two breaches. We will find which first and last nodes are breaching .
     Fist Breach:
     First =  prev - 30
     Last = root - 18
     Second Breach
     (Update the last here) Last = current root = 15

     Now swap First and Last

     Time Complexity: O(n)
     Space Complexity: O(h) ; height of the tree
     */
    TreeNode prev;
    boolean flag;
    TreeNode first;
    TreeNode last;
    public void recoverTree(TreeNode root) {
        if(root == null)    return;
        inorder(root);
        int temp = first.val;
        first.val = last.val;
        last.val = temp;
    }
    private void inorder(TreeNode root) {
        if(root == null)    return;
        inorder(root.left);
        if(prev != null && prev.val >= root.val) {
            if(!flag) { //first breach
                first = prev;
                last = root;
                flag = true;
            } else { // second breach
                last = root;
                return;
            }
        }
        //Reset previous to root
        prev = root;
        inorder(root.right);
    }

    public static void main(String[] args) {

    }
}