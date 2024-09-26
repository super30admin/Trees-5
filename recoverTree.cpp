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
    TreeNode *first=NULL,*second=NULL,*prev=NULL;
    void recoverTree(TreeNode* root) {
        helper(root);
        swap(first,second);
        if (first!=NULL && second!=NULL) {
            int temp=first->val;
            first->val=second->val;
            second->val=temp;
        }
    }
    void helper(TreeNode* root) {
        if (root!=NULL) {
            helper(root->left);
            if (prev!=NULL && root->val<prev->val) {
                if (first==NULL) {
                    first=prev;
                    second=root;
                } else {
                    second=root;
                }
            }
            prev=root;
            helper(root->right);
        }
    }
};