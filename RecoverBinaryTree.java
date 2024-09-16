import java.util.Stack;

public class RecoverBinaryTree {
}
// Time Complexity : O(n)
// Space Complexity :O(h)
// n is the number of nodes in the tree
// h is the height of the tree
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
//Recursive Solution
// TC: O(n)
// SC: O(h)
// n is the number of nodes in the tree
// h is the height of the tree


// Definition for a binary tree node.
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

class Solution {
    TreeNode first;
    TreeNode second;
    TreeNode prev;
    public void recoverTree(TreeNode root) {
        if(root == null)
            return;
        inOrder(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void inOrder(TreeNode root){
        //base case
        if(root == null)
            return;

        //logic
        inOrder(root.left);
        if(prev != null && prev.val >= root.val){
            //breach found
            if(first == null){
                //first breach
                first = prev;
                second = root;
            }
            else{
                //second breach
                second = root;
            }
        }
        prev = root;
        inOrder(root.right);
    }
}



//Iterative Solution
//TC: O(n)
//SC: O(h)
// n is the number of nodes in the tree
// h is the height of the tree

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    TreeNode first;
    TreeNode second;
    public void recoverTree(TreeNode root) {
        if(root == null)
            return;
        inOrder(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void inOrder(TreeNode root){
        //logic
        TreeNode prev = null;
        Stack<TreeNode> st = new Stack<>();

        while(root != null || !st.isEmpty()){
            while(root != null){
                st.push(root);
                root = root.left;
            }
            root = st.pop();

            if(prev != null && prev.val >= root.val){
                //breach found
                if(first == null){
                    //first breach
                    first = prev;
                    second = root;
                }
                else{
                    //second breach
                    second = root;
                }
            }
            prev = root;
            root = root.right;
        }
    }
}