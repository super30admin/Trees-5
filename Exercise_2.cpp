/* 
    Time Complexity                              :  O(N)
    Space Complexity                             :  O(1)
    Did this code successfully run on Leetcode   :  Yes
    Any problem you faced while coding this      :  No
*/

#include <bits/stdc++.h> 
using namespace std;  

// https://leetcode.com/problems/recover-binary-search-tree/

class Solution {
private:
    bool fixed;
    TreeNode *x, *y;
    TreeNode *prev;
public:
    void recoverTree(TreeNode* root) {
        inOrder(root);
        swap(x->val,y->val);
    }
    
    void inOrder(TreeNode *root) {
        if(!root or fixed == true) return;
        
        inOrder(root->left);
        if(prev and root->val < prev->val) {
            if(!x) {
                x = prev;
                y = root;
            } else {
                y = root;
            }
        }
        
        prev = root;
        inOrder(root->right);
        
    }
};