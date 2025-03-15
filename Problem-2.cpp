// https://leetcode.com/problems/recover-binary-search-tree/description/
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

// Recursive Aprroach
class Solution {
    public:
        TreeNode* prev;
        TreeNode* first;
        TreeNode* second;
    
        void helper(TreeNode* root){
            if(root == NULL) return;
            helper(root->left);
            if(prev != NULL && prev->val >= root->val){
                if(first == NULL){
                    first = prev;
                    second = root;
                }
                else{
                    second = root;
                }
            }
            prev = root;
            helper(root->right);
        }
        void recoverTree(TreeNode* root) {
            helper(root);
            int temp = first->val;
            first->val = second->val;
            second->val = temp;
            
        }
    };


// Stack Implementation
class Solution {
    public:
        void recoverTree(TreeNode* root) {
            TreeNode* prev = NULL;
            TreeNode* first = NULL;
            TreeNode* second = NULL;
            stack<TreeNode*> st;
            while(!st.empty() || root != NULL){
                while(root != NULL){
                    st.push(root);
                    root = root->left;
                }
                root = st.top(); st.pop();
                if(prev != NULL && prev->val >= root->val){
                    if(first == NULL){
                        first = prev;
                        second = root;
                    }
                    else{
                        second = root;
                    }
                }
                prev = root;
                root = root->right;
            }
            int temp = first->val;
            first->val = second->val;
            second->val = temp;
            
        }
    };