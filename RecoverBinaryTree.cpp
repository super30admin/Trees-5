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
//Time complexity : O(n)
//Space complexity : O(h)

class Solution {
public:
    TreeNode* prev;
    TreeNode* first; 
    TreeNode* second;
    void recoverTree(TreeNode* root) {
        if(root == nullptr)
            return;
        
        inorder(root);
        int temp = first->val;
        first->val = second->val;
        second->val = temp;
    }
    
    void inorder(TreeNode* root)
    {
        if(root == nullptr)
            return;
        
        inorder(root->left);
        
        if(prev != nullptr && prev->val >= root->val)
        {
            if(first == nullptr)
            {
                first = prev;
                second = root;
            }
            else
            {
                second = root;
                return;
            }
        }
        
        prev = root;
        inorder(root->right);
    }
};