// Time Complexity : O(N) where N=Number of nodes
// Space Complexity : O(H)H-->Height of Tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
//Solved using Inorder traversal method.

class Solution {
public:
    TreeNode* prev, *first,*last;
    bool flag;
    void recoverTree(TreeNode* root) {
        flag = false;
        helper(root);
        int temp = first->val;
        first->val = last->val;
        last->val = temp;
    }
    
    void helper(TreeNode* curr){
        //base
        if(curr==NULL) return;
        
        helper(curr->left);
        if(prev!=NULL && prev->val > curr->val){
            if(!flag){
                flag = true;
                first = prev;
                last = curr;
            }else{
                last = curr;
            }
        }
        prev = curr;
        helper(curr->right);
        
    }
};
