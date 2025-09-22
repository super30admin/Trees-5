#include<iostream>
#include<bits/stdc++.h>
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
/*
We do an in-order traversal recursively to detect two nodes where the BST property is violated.
We track the first and second misplaced nodes using a previous pointer.
After traversal, we simply swap their values to restore the BST.
*/
class Solution{
    TreeNode* first;
    TreeNode* second;
    TreeNode* prev;
public:
    void recoverTree(TreeNode* root){
        helper(root);
        swap(first->val, second->val);
    }
private:
    void helper(TreeNode* root){
        if(root == nullptr) return;
        helper(root->left);

        if(prev != nullptr && prev->val >= root->val){
            if(first == nullptr){
                first = prev;
                second = root;
            }else{
                second = root;
            }
        }
        prev = root;
        helper(root->right);
    }
};
