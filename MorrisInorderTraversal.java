import java.util.ArrayList;
import java.util.List;

public class MorrisInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) { //O(n*h) T.C w.c, O(n) T.C amortized, O(1) S.C
        //Morris inorder traversal
        List<Integer> result = new ArrayList<>();
        while(root != null) { //traverse until root is null
            if(root.left == null) { //if root doesn't have any left child
                result.add(root.val); //add this to the result as inorder value
                root = root.right; //and move root to root.right
            } else { //if root has a left child
                TreeNode prev = root.left; //assign this left child to temp node prev
                while(prev.right != null && prev.right != root) { //go to the right most node in this subtree
                    //at one point, there can be a circle formed when prev.right -> prev itself, in this case, break
                    prev = prev.right; //move prev to the right most node
                }

                if(prev.right == null) { //if the above while loop breaks when the last right node found
                    prev.right = root; //assign its right pointer to current root
                    root = root.left; //and move root to its left child
                } else { //if cycle found
                    result.add(root.val); //add the current root's value to result
                    prev.right = null; //sever the right connection
                    root = root.right; //and move root to its right child
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        /*
        Constructing the following binary tree:

                1
               / \
              2   3
             / \
            4   5
        */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        // Create an instance of BinaryTree
        MorrisInorderTraversal tree = new MorrisInorderTraversal();

        // Perform inorder traversal and print the result
        System.out.println("Inorder traversal of the binary tree:");
        List<Integer> result = tree.inorderTraversal(root);
        System.out.println(result);
    }
}