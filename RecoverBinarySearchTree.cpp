//Time Complexity O(n)
// Space Complexity O(h)
//Problem successfully executed on leetcode
//No problems faced while coading this.


#include<iostream>
#include<vector>
#include<queue>
#include<map>
#include<stack>
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
    
    TreeNode* first=NULL;
    TreeNode* second=NULL;
    TreeNode* prev=NULL;
    void recoverTree(TreeNode* root) {
        inorder(root);
        int temp=first->val;
        first->val=second->val;
        second->val=temp;
    }
    
    
    void inorder(TreeNode* root)
    {
        //base
        if(root==NULL)
        {
            return;
        }
        
        
        //logic
        inorder(root->left);
        if(prev != NULL && root->val <= prev->val)
        {
            if(first==NULL)
            {
                first=prev;
                second = root;
            }
            else
            {
                second =root;
            }
        }
        prev=root;
        inorder(root->right);
    }
};