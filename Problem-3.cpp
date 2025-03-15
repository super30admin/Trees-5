// https://leetcode.com/problems/binary-tree-inorder-traversal/
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public:
        vector<int> inorderTraversal(TreeNode* root) {
             vector<int> res;
            TreeNode* curr = root;
            
            while (curr != NULL) {
                if (curr->left == NULL) {
                    res.push_back(curr->val);
                    curr = curr->right;
                } else {
                    TreeNode* prev = curr->left;
                    while (prev->right != NULL && prev->right != curr) {
                        prev = prev->right;
                    }
                    if (prev->right == NULL) {
                        prev->right = curr; 
                        curr = curr->left;
                    } else {
                        prev->right = NULL;
                        res.push_back(curr->val);
                        curr = curr->right;
                    }
                }
            }
            
            return res;
        }
    };