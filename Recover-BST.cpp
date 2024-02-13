// Time Complexity : O(N)

// Space Complexity : O(1)

// Did this code successfully run on Leetcode : YES

// Appoarch: Using the inorder traversal to check the wrong elements and store it in
// first and second to swap it.

// 99. Recover Binary Search Tree

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

class Solution {
public:
    TreeNode* prev;
    TreeNode* first;
    TreeNode* second;
    void inorder(TreeNode* root){
        if(root == NULL) return;
        inorder(root->left);
        if(prev != NULL && prev->val >= root->val){
            if(first == NULL){
                first = root;
                second = prev;
            }
            else{
                first = root;
            }
        }
        prev = root;
        inorder(root->right);
    }
    void recoverTree(TreeNode* root) {
        inorder(root);
        swap(first->val,second->val);
    }
};