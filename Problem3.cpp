// Problem - Morris Inorder traversal
//  Time Complexity : O(n)
//  Space Complexity : O(1)
//  Did this code successfully run on Leetcode : Yes
//  Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// 1. We first travel to the left, and set the extreme right node and connect it
// to root
// 2. We then move to left and if pred->right is root, we push the node and then
// change it's right to nullptr and move towards right
// 3. If its null,  we set the right to root, and move towards left
// 3. If left is null, then we push the node and go towards right

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

class Solution {
public:
  vector<int> inorderTraversal(TreeNode *root) {
    TreeNode *curr = root;
    vector<int> res;
    while (curr) {
      if (curr->left == nullptr) {
        res.push_back(curr->val);
        curr = curr->right;
      } else {
        TreeNode *pred = curr->left;
        while (pred->right && pred->right != curr) {
          pred = pred->right;
        }
        if (pred->right == nullptr) {
          pred->right = curr;
          curr = curr->left;
        }
        if (pred->right == curr) {
          res.push_back(curr->val);
          pred->right = nullptr;
          curr = curr->right;
        }
      }
    }
    return res;
  }
};
