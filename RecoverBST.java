//Inorder recursion solution

class Solution {

    // Time Complexity : 0(n) where n is the no. of nodes in tree
// Space Complexity :0(h) where h is the height of the tree(recursive stack space)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach


    TreeNode first, prev, second;       //I am taking first to store the 1st node when 1st breach happens, 2nd to store the 2nd breack and previous to keep a pointer that points to previous node
    boolean flag;   //to optimize and not go further when both breaches are found
    public void recoverTree(TreeNode root) {
        inorder(root);
        int temp = first.val;   //swapping the values back
        first.val = second.val;
        second.val = temp;
    }
    public void inorder(TreeNode root){
        if(root == null){   //base condition
            return;
        }
        inorder(root.left); //doing inorder traversal
        if(prev != null && root.val <= prev.val){//in BST, the left node should be less than the root, so checking if it is not, that means there is a breach and we record it
            if(first == null){  //recording the first breach in first variable
                first = prev;
                second = root;
                flag = true;
            }
            else{
                second = root;  //at 1st breach, assigning the root's value to second as there might be only one breach and hence taking care of that case
                //if there is a 2nd breach, just the value of 2nd will be overwritten
                flag = false;
            }
        }
        prev = root;    //assigning null to the 1st node or smallest node
        if(!(flag == false && first != null && second != null)){
            inorder(root.right);
        }
    }
}

//Iterative Approach

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
    TreeNode prev, first, second;
    public void recoverTree(TreeNode root) {
        Stack<TreeNode> s = new Stack<>();
        while(root != null || !s.isEmpty()){
            while(root != null){
                s.push(root);
                root = root.left;
            }
            root = s.pop();
            if(prev != null && prev.val >= root.val){
                if(first == null){
                    first = prev;
                }
                second = root;
            }
            prev = root;
            root = root.right;
        }
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
}