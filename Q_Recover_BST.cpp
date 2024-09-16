
//## Problem2 Recover Binary Search Tree
//(https://leetcode.com/problems/recover-binary-search-tree/)


//TC- O(n) as going over all nodes
//SC- O(h) as recursive stack space ,so height h

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    TreeNode* first;
    TreeNode* second;
    void recoverTree(TreeNode* root) {
        
        if(root==NULL){
            return;
        }
        TreeNode* prev= NULL;
        int matches =0;
        inorder(root,prev, matches);

        swap(first->val ,second->val);
        
    }
    
    void inorder(TreeNode* root , TreeNode* &prev ,int &matches){
        
        if(root==NULL ){
            return;
        }
        //traverse in inorder way
        inorder( root->left, prev, matches);
        if( (prev != NULL) &&  (prev->val >= root->val) ){
            if(matches==0){
                first = prev;
                matches += 1;
            } 
            second= root;     
        }
        prev = root;
        inorder( root->right, prev, matches);
    }
};