//Time Complexity- O(n)
//Space Complexity- O(n)

class Solution {
public:
    TreeNode* first=NULL;
    TreeNode* second=NULL;
    TreeNode* prev=NULL;
    void recoverTree(TreeNode* root) {
        
        findNodes(root);
        int temp=first->val;
        first->val=second->val;
        second->val=temp;
    }
    
    void findNodes(TreeNode* root){
        
        if(root==NULL){
            return;
        }
        
        findNodes(root->left);
        if(prev!=NULL){
            if(prev->val>root->val){
                if(first==NULL){
                    first=prev;
                }
                second=root;
            }
        }
        prev=root;
        findNodes(root->right);
    }
};