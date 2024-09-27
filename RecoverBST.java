/*
 * #99. Recover Binary Search Tree
 * 
 * Two elements of a binary search tree (BST) are swapped by mistake.

Recover the tree without changing its structure.

Example 1:

Input: [1,3,null,null,2]

   1
  /
 3
  \
   2

Output: [3,1,null,null,2]

   3
  /
 1
  \
   2
   
Example 2:

Input: [3,1,4,null,null,2]

  3
 / \
1   4
   /
  2

Output: [2,1,4,null,null,3]

  2
 / \
1   4
   /
  3
  
Follow up:

1. A solution using O(n) space is pretty straight forward.
2. Could you devise a constant space solution?

 */


/*
 * Time Complexity: O (V + E) -> Where 'V' is nodes of a BST, no edges since its a tree. Time to traverse through all nodes of a tree
 * 
 * Space Complexity: O (maxDepth) -> Explicit stack to store nodes equal to max depth at a time in a stack
 * 
 * Did this code successfully run on leetcode: Yes
 * 
 * Any problem you faced while coding this: No
 * 
 */

package com.s30.edu.trees5;

import java.util.Stack;

// Definition for a binary tree node.
class TreeNode30 {
     int val;
     TreeNode30 left;
     TreeNode30 right;
     TreeNode30() {}
     TreeNode30(int val) { this.val = val; }
     TreeNode30(int val, TreeNode30 left, TreeNode30 right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
}

/*
* This problem is similar to the Validate BST problem
* We need to perform Inorder traversal on a BST to check which elements needs to be swapped to recover a BST
* Since, we are using Iterative approach, we need an explicit stack to store the nodes of a BST
*/
public class RecoverBST {
	 public void recoverTree(TreeNode30 root) {
	        
	        // #1. Base condition 
	        if(root == null){
	            return;
	        }
	        
	        // #2. Iterative approach -> Craete explicit stack 
	        Stack<TreeNode30> stack = new Stack<TreeNode30>();
	        
	        // #3. We need two pointers x and y -> two nodes that needs to be swapped and 'prev' pointer to traverse and keep track of previous node
	        /*
	        * x -> holds the popped(current) node and it changes whenever prev node > curr node
	        * y -> It changes to 'prev' value only when y == null initially
	        */
	        TreeNode30 prev = null;
	        TreeNode30 x = null;
	        TreeNode30 y = null;
	        
	        // #4. Start the Inorder traversal
	        
	        // When stack is empty, we will enter while loop if root is not null
	        while(!stack.isEmpty() || root != null){
	            
	            // Inorder traversal
	            while(root != null){
	                stack.push(root);
	                root = root.left;
	            }
	            
	            TreeNode30 popped = stack.pop();
	            
	            if(prev != null && prev.val > popped.val){
	                // update x pointer to current node
	                x = popped;
	                
	                if(y == null){
	                    y = prev;
	                }
	                /*
	                * We are not using swap() function inside else block 
	                * consider eg. [1, 3, 2, 4]
	                * When we have x = 2, y = 3, our stack is empty and 4.right is also empty, we exit while loop
	                * and never go to else block which has swap() function, so call the swap() function outside while loop
	                */
	                else{
	                    // come out of while loop
	                    break;
	                }
	                
	            }
	            
	            // Update the 'prev' pointer
	            prev = popped;
	            // go to right of a popped node
	            root = popped.right;
	        }
	        
	        // swap the two nodes to recover a BST
	        swap(x, y);
	        
	    }
	    
	 // Swap function
	    public void swap(TreeNode30 x, TreeNode30 y){
	        int temp = x.val;
	        x.val = y.val;
	        y.val = temp;
	    }
	    
}
