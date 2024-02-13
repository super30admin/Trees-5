// Time Complexity : O(N)

// Space Complexity : O(1)

// Did this code successfully run on Leetcode : YES

// Appoarch: Using the Morris inorder traversal, creating a link between right and curr
// elements to get a inorder without using recursion stack or stack.

// 94. Binary Tree Inorder Traversal

#include <bits/stdc++.h>
using namespace std;

 // Definition for a binary tree node.
 struct TreeNode {
      int val;
      TreeNode *left;
      TreeNode *right;
      TreeNode() : val(0), left(nullptr), right(nullptr) {}
      TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
      TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
  };

 //Morris Inorder Traversal
class Solution {
public:
    vector<int> inorderTraversal(TreeNode* root) {
        vector<int> result;
        TreeNode* curr = root;
        while(curr != NULL){
            if(curr->left == NULL){
                result.push_back(curr->val);
                curr = curr->right;
            }
            else{
                TreeNode* pre = curr->left;
                while(pre->right != NULL && pre->right != curr){
                    pre = pre->right;
                }
                if(pre->right == NULL){
                    pre->right = curr;
                    curr = curr->left;
                }
                else{
                    pre->right = NULL;
                    result.push_back(curr->val);
                    curr = curr->right;
                }
            }
        }
        return result;
    }
};