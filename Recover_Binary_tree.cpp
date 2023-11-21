
 //Time - O(n)
class Solution {
TreeNode* prev;
TreeNode* first;
TreeNode* second;

public:
    void recoverTree(TreeNode* root) {
        if(root==NULL)return;
        inorder(root);
        int temp = first->val;
        first->val = second->val;
        second->val = temp;
    }
private:
    void inorder(TreeNode* root){
        //base case
        if(root==NULL)return;

        inorder(root->left);
        if(prev!=NULL && root->val<=prev->val){
            if(first==NULL){
                //first breach
                first = prev;
                second = root;
            }
            else{
                //second breach
                second = root;
            }
        }
        prev = root;
        inorder(root->right);
}    
};
