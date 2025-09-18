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
We walk through the tree using Morris traversal, without stack or recursion.
If a node has no left, we print it and go right; else we link the predecessor to current.
When that link brings us back, we remove it and print the node.
*/
class Solution{
void morrisInorderTraversal(TreeNode* root) {
        TreeNode* curr = root;
        while(curr->left != nullptr){
            if(curr->left == nullptr){
                cout << curr->val << endl;
                curr = curr->right;
            }else{
                TreeNode* pre = curr->left;
                while(pre->right != nullptr && pre->right != curr){
                    pre = pre->right;
                }

                if(pre->right == nullptr){
                    pre->right = curr;
                    curr = curr->left;
                }else{
                    pre->right = nullptr;
                    cout << curr->val << endl;
                    curr = curr->right;
                }
            }
        }
    }
};
