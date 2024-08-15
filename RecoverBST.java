public class RecoverBST {
    TreeNode first;
    TreeNode second;
    TreeNode prev;
    boolean flag;
    public void recoverTree(TreeNode root) {
        inorder(root);
        int temp = first.val; //swap value of first and second
        first.val = second.val;
        second.val = temp;
    }

    private void inorder(TreeNode root) { //O(n) T.C, O(h) S.C
        if(root == null) return;

        inorder(root.left);

        if(prev != null) { //if prev is not null
            if(prev.val > root.val) { //if the prev's value is greater than root's val
                if(first == null) { //if this is the first mismatch
                    //Ex: 0,10,40,30,50,70,80 -> 40 and 30 are first mismatches
                    //swap 40 and 30
                    first = prev; //make the prev as first
                    second = root; //and current root as second
                } else { //if second mismatch occurs
                    //Ex: 0,10,70,40,50,30,80 -> 70,40 is first mismatch and 50,30 is second mismatch
                    //swap only 70 and 30
                    second = root; //update second's value to current root
                    flag = true; //change the flag to true that mismatches have been found
                }
            }
        }

        prev = root; //after left child is processed, make the root as prev
        if(!flag) inorder(root.right);
    }

    public static void main(String[] args) {
        /*
        Constructing the following BST:

                3
               / \
              1   4
                 /
                2

        The nodes 2 and 3 are swapped, so the tree is not a valid BST.
        The correct tree should be:

                2
               / \
              1   4
                 /
                3
        */

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(2);

        // Printing original tree (inorder)
        System.out.println("Original tree (inorder): ");
        printInOrder(root);
        System.out.println();

        // Recover the BST
        RecoverBST recoverBST = new RecoverBST();
        recoverBST.recoverTree(root);

        // Printing recovered tree (inorder)
        System.out.println("Recovered tree (inorder): ");
        printInOrder(root);
        System.out.println();
    }

    // Helper method to print the tree inorder
    private static void printInOrder(TreeNode root) {
        if (root != null) {
            printInOrder(root.left);
            System.out.print(root.val + " ");
            printInOrder(root.right);
        }
    }
}
