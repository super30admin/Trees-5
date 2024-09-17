// Time Complexity :O(n) where n in the number of nodes in a tree
// Space Complexity : O(H) H is height of the tree 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
    TreeNode* prev;
    TreeNode* first;
    TreeNode* second;
    bool flag = false;
    bool flag2 = true;
public:
    void recoverTree(TreeNode* root) {
        if(!root) return;
        inorder(root);
        swap(first->val,second->val);
    }
    void inorder(TreeNode* root){
        if(!root) return;
        inorder(root->left);
        if(prev && prev->val > root->val){
            if(!flag){
                first = prev;
                second = root;
                flag = true;
            }
            else {
                second = root;
                flag2 = false;
            }
        }
        prev = root;
        if(flag2) inorder(root->right);
    }
};