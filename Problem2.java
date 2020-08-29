// There are two approaches
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

import java.util.Stack;

// Your code here along with comments explaining your approach
// Approach 1: DFS with prev reference (Recursive)
// We know that for inorder traversal if prev node is less than current node.
// If this conditions is not upholded means that node is one of swapped node.
// Find both nodes and swap their values
// Time Complexity : O(n)
//      n: elements of the tree
// Space Complexity : O(h)
//      h: height of the tree
//   This is recursive stack space
class Problem2S1 {

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
 
    // global references
    TreeNode first;
    TreeNode last;
    TreeNode prev;

    /** Swap Node's value */
    public void recoverTree(TreeNode root) {
        // do dfs
        dfs(root);
        // check both found then swap
        if(first!= null ){
            int temp = first.val;
            first.val = last.val;
            last.val = temp;
        }
    }
    
    /** find nodes to be swapped doing inorder traversal*/
    private void dfs(TreeNode root){

        // base case
        if(root == null)
            return;

        // go left
        dfs(root.left);
        // check prev val
        if(prev != null){
            if(prev.val > root.val){
                // check first not found
                if(first == null){
                    first = prev;
                }
                last = root; // in case we dont find last(second element to be swapped)
            }
        }
        // make prev root
        prev =  root;

        // go right
        dfs(root.right);
    }
}

// Your code here along with comments explaining your approach
// Approach 2: DFS with prev reference (Iterative)
// We know that for inorder traversal if prev node is less than current node.
// If this conditions is not upholded means that node is one of swapped node.
// Find both nodes and swap their values
// Time Complexity : O(n)
//      n: elements of the tree
// Space Complexity : O(h)
//      h: height of the tree

class Problem2S2 {

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
    
    /** get recovered tree */
    public void recoverTree(TreeNode root) {

        // stack for dfs
        Stack<TreeNode> myStack = new Stack<>();
        // references
        TreeNode current =  root;
        TreeNode first, last, prev;
        first = last = prev = null;

        // iterate all elements of stack
        while(!myStack.isEmpty() || current != null){
            
            // go left
            while(current != null){
                
                myStack.push(current);
                current = current.left;
            }

            // pop left-most element
            current = myStack.pop();
            
            // check with previous
            if(prev != null && prev.val > current.val){
                // check both pointer
                if(first == null)
                    first =  prev; 
                last = current;
            }
            
            // update previous
            prev = current;

            // update current
            current = current.right;
        }
        
        // swap first and last
        int temp = first.val;
        first.val = last.val;
        last.val = temp;
    }
}