//Time Complexity:O(n)
//Space Complexity:O(h)
#include<iostream>
#include<vector>
using namespace std;

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
   TreeNode*a = nullptr,*b = nullptr,*prev = nullptr;
    void recoverTree(TreeNode* root) {
        helper(root);
        int temp = a->val;
        a->val = b->val;
        b->val = temp;
    }
    void helper(TreeNode* root) {
        if(root == nullptr) return;
        helper(root->left);
        if(prev != nullptr && prev->val >= root->val) {
            if(a == nullptr) {
                a = prev;
                b = root;
            } else {
                b = root;
            }
        }
        prev = root;
        helper(root->right);
    }
};