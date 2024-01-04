//TC: O(n)
//SC: O(h)

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
    TreeNode *first;
    TreeNode *second;
    TreeNode *prev;
public:
    void recoverTree(TreeNode* root) {
        inorder(root);
        int temp = first->val;
        first->val = second->val;
        second->val = temp;
    }

    private:

    void inorder(TreeNode* root)
    {
        //base case
        if(root==NULL) return;

        inorder(root->left);
        if(prev != NULL && prev->val>=root->val)
        {
            if(first == NULL)
            {
                first =prev;

            }
            second = root;
        }
        prev = root;
        inorder(root->right);
    }
};