/**
 * Definition for a binary tree node.
 * **/
struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};


class Solution {
public:
    TreeNode *prev, *first, *second;
    void recoverTree(TreeNode* root) {
        inorder(root);
        int temp=first->val;
        first->val = second->val;
        second->val = temp;
    }

    void inorder(TreeNode* root) {
        if(root == nullptr) {
            return;
        }
        inorder(root->left);
        if(prev != nullptr) {
            if(root->val < prev->val) { // Breach found
                if(first == nullptr) { // If Breach 1
                    first = prev;
                }
                second = root;
            }
        }
        prev = root;
        inorder(root->right);
    }
};