/*
TC : O(N)
SC : O (H)
*/
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
class Solution
{
public:
    vector<int> inorderTraversal(TreeNode *root)
    {
        if (root == nullptr)
        {
            return {};
        }
        vector<int> result;

        stack<TreeNode *> st;
        while (root != nullptr || !st.empty())
        {
            while (root)
            {
                st.push(root);
                root = root->left;
            }
            TreeNode *curr = st.top();
            st.pop();
            result.push_back(curr->val);
            root = curr->right;
        }

        return result;
    }
};