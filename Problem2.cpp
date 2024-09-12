
// Time Complexity : O(n) 
// Space Complexity : O(h) height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No 

// Recover BST

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
    TreeNode *prev = NULL;
    TreeNode *first = NULL;
    TreeNode *last = NULL;
    bool flag = false;
public:
    void recoverTree(TreeNode* root) {
        if(root == NULL)
            return;
        
        inorder(root);
        int temp = first->val;
        first->val = last->val;
        last->val = temp;
    }
    
    void inorder(TreeNode* root){
        //base
        if(root == NULL)
            return;
        
        //logic
        inorder(root->left);
        if(prev != NULL && prev->val >= root->val){
            if(!flag){  // neighbours breach
                first = prev;
                last = root;
                flag = true;
            }
            else{   // 2nd breach not neighbours
                last = root;
                return;
            }
        }
        
        prev = root;
        
        inorder(root->right);
    }
};