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
    TreeNode*first,*last,*prev;
public:
    void recoverTree(TreeNode* root) {
        if(root==NULL)
            return;
        inorder(root);
        swap(first->val,last->val);
    }
    void inorder(TreeNode* root)
    {
        if(root==NULL)
            return;
        inorder(root->left);
        //Logic
        if (first==NULL&&(prev==NULL || prev->val>=root->val))
            first=prev;    
        // If first element is found, assign the second element to the root (refer to 2 in the example above)
        if (first!=NULL&&prev->val>=root->val)
            last=root;      
        prev=root;
        inorder(root->right);
    }
};