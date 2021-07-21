class Solution {
    TreeNode* prev;
    TreeNode* first;
    TreeNode* second;
public:
    void recoverTree(TreeNode* root) {
        dfs(root);
        
        swap(first->val, second->val);
    }
    
    void dfs(TreeNode* root) {
        if (!root) {
            return;
        }
        
        dfs(root->left);
        
        if (prev && !first && prev->val > root->val) {
            first = prev;
        }
        
        if (first && prev->val > root->val) {
            second = root;
        }
        
        prev = root;
        
        dfs(root->right);
    }
};
