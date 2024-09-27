import java.util.ArrayList;
import java.util.List;
/*
Time complexity: O(N), N is the number of nodes in the tree
Space Complexity: O(N), N is the size of recursive stack
Run on leetcode: yes
Any difficulties: no

Approach:
Well commented code, main idea is finding predecessor and comparing root value with that and swapping
accordingly
 */
public class RecoverBinarySearchTree {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(){}
        TreeNode(int val){
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static TreeNode x= null, y = null, pred = null;
    public static void recoverTree(TreeNode root){
        // first find swapped nodes using recursion

        swappedNodesOfBT(root);
        swapToRecover(x,y);
    }

    // find swapped nodes in the inorder sequence: left-> root -> right
    public static void swappedNodesOfBT(TreeNode root){
        if(root == null){
            return;
        }
        swappedNodesOfBT(root.left);
        // comparing root node with the predecessor node
        if(pred!= null && root.val<pred.val){
            y = root;
            if(x == null){
                x= pred;
            }else{
                return;
            }
        }
        pred = root;
        swappedNodesOfBT(root.right);
    }
    // Swapping two tree nodes to recover the BST
    public static void swapToRecover(TreeNode a, TreeNode b){
        int temp = a.val;
        a.val= b.val;
        b.val = temp;
    }
   public static List<Integer> result;
    public static List<Integer> inorderTraversal(TreeNode root){
        result = new ArrayList<>();
       inorder(root);
       return result;
    }
    public static void inorder(TreeNode root){
        if(root == null){
            return;
        }

        inorder(root.left);
        result.add(root.val);
        inorder(root.right);
    }
    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.right = new TreeNode(2);

        recoverTree(root);
        System.out.println("Recovered tree: "+ inorderTraversal(root));

    }
}
