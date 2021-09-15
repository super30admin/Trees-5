// Time Complexity : O(N) where N is the number of nodes
// Space Complexity :O(H) where H is the height od the tree.
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
public:
    TreeNode* prev, *first, *last;
    bool mismatch;
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
            if(!mismatch){
                first = prev;
                last = root;
                mismatch = true;
            }
            else{
                last = root;
                return;
            }
        }
        prev = root;
        inorder(root->right);
    }
};
