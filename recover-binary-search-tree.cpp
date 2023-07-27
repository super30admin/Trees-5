// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes

#include <iostream>

using namespace std;

// Definition for a binary tree node.
struct TreeNode {
    int val;
    TreeNode* left;
    TreeNode* right;
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
};

class Solution {
public:
    TreeNode* first = nullptr;
    TreeNode* last = nullptr;
    TreeNode* prev = nullptr;
    bool flag = false;

    void recoverTree(TreeNode* root) {
        if (root == nullptr) return;

        inorder(root);

        int temp = last->val;
        last->val = first->val;
        first->val = temp;
    }

    void inorder(TreeNode* root) {
        if (root == nullptr) return;

        inorder(root->left);

        if (prev != nullptr && root->val < prev->val) {
            if (!flag) {
                flag = true;
                first = prev;
                last = root;
            } else {
                last = root;
            }
        }

        prev = root;

        inorder(root->right);
    }
};
