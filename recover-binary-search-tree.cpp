//Time - O(n)
//Space - O(n)
class Solution {
public:
    TreeNode* left = NULL, *right = NULL;
    TreeNode* prev = NULL;
    void recoverTree(TreeNode* root) {
        
        stack<TreeNode*> st;
        
        while(root!=NULL || !st.empty()){
            while(root!=NULL){
                st.push(root);
                root = root->left;
            } 
            
            root = st.top();st.pop();
            if(prev!=NULL && prev->val > root->val){
                if(left==NULL){
                    left = prev;
                }
                right = root;
            }
            prev = root;
            root = root->right;
            
        }
        
        swap(left->val, right->val);
    }
    
};