
// Time complexity O(n)
// Space complexity O(n)
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
public:
    void recoverTree(TreeNode* root) {
        stack<TreeNode*> st;
        TreeNode* first = nullptr;
        TreeNode* second = nullptr;

        TreeNode* prev = nullptr;
        while(!st.empty() || root != nullptr) {
            
            while (root != nullptr) {
                st.push(root);
                root = root->left;
            }

            root = st.top();
            st.pop();
            
            if (prev != nullptr && prev->val >= root->val)
            {
                // first breach.
                if (first == nullptr)
                {
                    first = prev;
                }
                second = root; // second breach.
            }
            prev = root;       
            
            root = root->right;    
        }

        int temporary = first->val;
        first->val = second->val;
        second->val = temporary;

    }
};