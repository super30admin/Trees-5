/*
TC : O(n)
SC : O(n)
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
    void recoverTree(TreeNode *root)
    {
        if (root == nullptr)
        {
            return;
        }

        stack<TreeNode *> st;
        vector<TreeNode *> inorder;

        // inorder traversal
        while (root != nullptr || !st.empty())
        {
            while (root != nullptr)
            {
                st.push(root);
                root = root->left;
            }
            TreeNode *curr = st.top();
            st.pop();
            inorder.push_back(curr);
            root = curr->right;
        }

        // find the nodes not in ascending order
        TreeNode *first = nullptr;
        TreeNode *second = nullptr;
        TreeNode *prev = inorder[0], *curr;
        for (int i = 1; i < inorder.size(); i++)
        {
            curr = inorder[i];
            if (prev->val > curr->val)
            {
                if (first == nullptr)
                {
                    first = prev;
                    second = curr;
                }
                else
                {
                    second = curr;
                    break;
                }
            }
            prev = curr;
        }
        // swap
        int temp = first->val;
        first->val = second->val;
        second->val = temp;
    }
};