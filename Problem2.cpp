/* Problem Statement:

VERIFIED ON LEETCODE PLATFORM 
99. Recover Binary Search Tree
Hard

Two elements of a binary search tree (BST) are swapped by mistake.

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

    A solution using O(n) space is pretty straight forward.
    Could you devise a constant space solution?



 * Solution 1: (constant memory)
   Time Complexity : O(n) inorder traversal 
 * Space complexity :O(1)
 */

 /* Solution 2: TODO: discussed in class 
   Time Complexity : O(n)
 * Space complexity :O(1) 
 */

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public
    /* anamoly is defined as condition where in sorted order we get element not in order. for eg : 3,2,1
    * here 3 > 2 , so x becomes 3 , y becomes 2
    *  again when 2 > 1 , x remains 3 as it is never updated once it is stored, and y becomes 1
    * when we encounter it, we replace x with y to make it in sorted order.
    * here sorted order is taken as inorder traversal of a tree gives result in sorted order, so to fix the tree, we need to make sure
    * that the recovery is done by making it sorted again.
    */
    vector<TreeNode *> inorder_arr;
    TreeNode *x,*y, *prev; /* x: specify larger element in first anamoly, y: the smaller element in the anamoly whenever it is encountered */
    int anamoly_cnt;
    void inorder(TreeNode* root) {
        
        if (root == NULL) {
            return;
        }
        inorder(root->left);
        
        /* If prev is already there, then only process it */
        if (prev != NULL) {
            /* find anamoly */
            if (prev->val > root->val) {
                anamoly_cnt++;
                y = root;
                /* update x only once */
                if (x == NULL) {
                    x = prev;
                } else {
                    /* swap val for the nodes */
                    int temp = x->val;
                    x->val = y->val;
                    y->val = temp;
                    return;
                }
            }            
        }
        prev = root;
        inorder(root->right);
        
    }
    void recoverTree(TreeNode* root) {
        /* initialize extra variables */
        x = NULL;
        y = NULL;
        anamoly_cnt = 0;
        
        inorder(root);
        /* this is corner case having a tree for eg : [0,1] where anamoly happens only once */
        if (anamoly_cnt == 1) {
            int temp = x->val;
            x->val = y->val;
            y->val = temp;    
        }
    }
};
/* Execute on leetcode platform */


