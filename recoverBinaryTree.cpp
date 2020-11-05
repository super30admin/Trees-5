//time complexity:O((n)
//space complexity:O(1)
//executed on leetcode: yes
//approach:using inorder traversal
//any issues faced? no

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
    TreeNode* prev=NULL;
    TreeNode* x=NULL;
    TreeNode* y=NULL;
    void recoverTree(TreeNode* root) {
        inorder(root);
        int tmp=x->val;
        x->val=y->val;
        y->val=tmp;
    }
    void inorder(TreeNode* root)
    {
        if(root==NULL)
            return;
        inorder(root->left);
        if(prev!=NULL && prev->val > root->val)
        {
            if(x==NULL)
                x=prev;
            y=root;
        }
        prev=root;
        inorder(root->right);
    }
};