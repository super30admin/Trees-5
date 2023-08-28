//time O(n)
//space O(h)

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
        TreeNode* prev=NULL;
    void recoverTree(TreeNode* root) {
        Inorder(root);
        int temp = first->val;
        first->val = second->val;
        second->val = temp;
       

        

        
        
    }
    
    void Inorder(TreeNode* root){
        
       
        if(root == NULL){
           
            return;
        }



        Inorder(root->left);
        if(prev!=NULL && prev->val >= root->val){
            if(first == NULL){
                first = prev;
                second = root;
            }
            else{

                second = root;
            }
        }

        prev = root;
        
        Inorder(root->right);


    }
};