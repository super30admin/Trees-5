/*
 * #116. Populating Next Right Pointers in Each Node
 * 
 * You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:

struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}

Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

 

Follow up:

1. You may only use constant extra space.
2. Recursive approach is fine, you may assume implicit stack space does not count as extra space for this problem.
 

Example 1:
Refer image from leetcode


Input: root = [1,2,3,4,5,6,7]
Output: [1,#,2,3,#,4,5,6,7,#]
Explanation: Given the above perfect binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B. The serialized output is in level order as connected by the next pointers, with '#' signifying the end of each level.
 

Constraints:

1. The number of nodes in the given tree is less than 4096.
2. -1000 <= node.val <= 1000

 */


/*
 * Time Complexity: O (V + E) -> Vertices + Edges -> we are traversing through all the nodes of a tree, no edges since its a tree, vertices are nodes
 * 
 * Space Complexity: O (1) -> No extra space used
 * 
 * Did this code successfully run on leetcode: Yes
 * 
 * Any problem you faced while coding this: No
 * 
 */
package com.s30.edu.trees5;

//Definition for a Node.
class Node22 {
 public int val;
 public Node22 left;
 public Node22 right;
 public Node22 next;

 public Node22() {}
 
 public Node22(int _val) {
     val = _val;
 }

 public Node22(int _val, Node22 _left, Node22 _right, Node22 _next) {
     val = _val;
     left = _left;
     right = _right;
     next = _next;
 }
 
}

// Iterative approach
public class PopulateNextRightPointers {
	public Node22 connect(Node22 root) {
        // #1. Base condition
        if(root == null){
            return null;
        }
       
       /*
       * We will need two pointers 
       * 1. level
       *       1. To check if we have next level OR children nodes to process(populate next right pointers for each node)
       *       2. move the curr pointer from previous level to current level
       * 2. curr
       *       To populate next right pointers for each children nodes -> process children nodes
       *       'curr' pointer moves from left to right using 'next' which is already provided to us
       */
       
       // #2. Initialize the two pointers, starting with root
       Node22 level = root;
       Node22 curr = root;
       
       // #3. Start traversing the tree and populating the next right pointers for each node at each level
       
       // Outer while loop to check if we have next level to process the children
       while(level.left != null){
           
           // move the 'curr' pointer to current level once previous level's nodes are processed
           curr = level;
           
           // Inner while loop to populate next right pointers for each children node, until 'curr' becomes null
           while(curr != null){
               
               // populate the next right pointers
               curr.left.next = curr.right;
               
               if(curr.next != null){
                   curr.right.next = curr.next.left;
               }
               
               curr = curr.next;
               
           }
           
           // Go to next level
           level = level.left;
           
       }
       
       // #4. return the binary tree with populated next right pointers
       return root; 
       
   }
	
}
