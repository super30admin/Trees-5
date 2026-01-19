// Problem - Recover binary tree
//  Time Complexity : O(n)
//  Space Complexity : O(1)
//  Did this code successfully run on Leetcode : Yes
//  Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// 1. We use morris traversal here to traverse the tree and keep track of prev,
// first and second
// 2. While traversing, if prev > root, we store it in first and second
// 3. After the traversal, we swap the values and return root

#include <iostream>
#include <utility>
using namespace std;

struct TreeNode {
  int val;
  TreeNode *left;
  TreeNode *right;
  TreeNode() : val(0), left(nullptr), right(nullptr) {}
  TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
  TreeNode(int x, TreeNode *left, TreeNode *right)
      : val(x), left(left), right(right) {}
};

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left),
 * right(right) {}
 * };
 */
class Solution {
public:
  void recoverTree(TreeNode *root) {
    TreeNode *first = nullptr;
    TreeNode *second = nullptr;
    TreeNode *prev = nullptr;
    while (root) {
      if (root->left == nullptr) {
        if (prev && prev->val >= root->val) {
          if (!first) {
            first = prev;
            second = root;
          } else {
            second = root;
          }
        }
        prev = root;
        root = root->right;
      } else {
        TreeNode *pred = root->left;
        while (pred && pred->right != nullptr && pred->right != root) {
          pred = pred->right;
        }
        if (pred->right == nullptr) {
          pred->right = root;
          root = root->left;
        } else if (pred->right == root) {
          if (prev && prev->val >= root->val) {
            if (!first) {
              first = prev;
              second = root;
            } else {
              second = root;
            }
          }
          prev = root;
          pred->right = nullptr;
          root = root->right;
        }
      }
    }
    if (first && second) {
      swap(first->val, second->val);
    }
  }
};
