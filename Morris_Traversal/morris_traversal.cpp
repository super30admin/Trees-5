#include<bits/stdc++.h>
using namespace std;
/**
 * Definition for a binary tree node.
 * */
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
    vector<int> inorderTraversal(TreeNode* root) {
        vector<int> ans;
        TreeNode *curr = root, *pre=nullptr;
        while(curr != nullptr) {
            if(curr->left == nullptr) {
                ans.push_back(curr->val);
                curr = curr->right;
            }
            else {
                // Find pre
                pre = curr->left;
                while(pre->right != nullptr && pre->right != curr) {
                    pre = pre->right;
                }

                // If left was not explored earlier
                if(pre->right == nullptr) {
                    pre->right = curr;
                    curr = curr->left;
                }
                // If left was explored earlier
                // The explore this node and go right because left and current is explored
                else {  // else if(pre->right != curr)
                    ans.push_back(curr->val);
                    pre->right = nullptr;
                    curr = curr->right;
                }
            }
        }
        return ans;
    }
};