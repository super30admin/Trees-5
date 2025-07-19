//time complexity- O(n) in amortized form , o(n * h) in the worst case
//space complexity- O(1)
import com.sun.source.tree.Tree;

import java.util.*;
public class MorrisInorderTraversal {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val =val;
            left = right = null;
        }
    }
    static List<Integer> inorderTraversal(TreeNode root) {
        if(root == null) return new ArrayList<>();
        List<Integer> inorder = new ArrayList<>();
        TreeNode curr = root;

        while(curr != null) {
            if(curr.left == null) {
                inorder.add(curr.val);
                curr = curr.right;
            } else {
                TreeNode prev = curr.left;
                while(prev.right != null && prev.right != curr) {
                    prev = prev.right;
                }
                if(prev.right == null) {
                    prev.right = curr;
                    curr = curr.left;

                } else {
                    prev.right = null;
                    inorder.add(curr.val);
                    curr = curr.right;
                }
            }
        }
        return inorder;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        /*
                    1
                 /    \
               2        3
            /   \      /  \
           4    5     6    7

         */
        System.out.println("Morris Inorder Treversal " + inorderTraversal(root));
    }
}
