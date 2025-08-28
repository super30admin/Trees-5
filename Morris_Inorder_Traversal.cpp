//Time Complexity :O(n)
//Space Complexity:O(1)
#include<iostream>
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
    void morrisInorderTraversal(TreeNode* root) {
        TreeNode* curr = root;
        while(curr != nullptr){
            if(curr->left == nullptr){
                cout << curr->val << endl;
                curr = curr->right;
            }else{
                TreeNode* prev = curr->left;
                while(prev->right != nullptr && prev->right != curr){
                    prev = prev->right;
                }
                if(prev->right == nullptr){
                    prev->right = curr;
                    curr = curr->left;
                }else{
                    prev->right = nullptr;
                    cout << curr->val << endl;
                    curr = curr->right;
                }
            }
        }
    }
};