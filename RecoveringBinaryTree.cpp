/**
Intuition: Since it is a bst, we can do inorder traversal to get a sorted tree values.
We can then check in this sorted array where we breach the bst condition.
#####################################################################
Time Complexity : O(N), N = Number of nodes in the tree
Space Complexity : O(H), H = Height of the tree
#####################################################################

*/
class Solution {
public:
    TreeNode* prev = NULL;
    TreeNode* first = NULL;
    TreeNode* second = NULL;
    void recoverTree(TreeNode* root) {
        helper(root);
        int temp = first->val;
        first->val = second->val;
        second->val = temp;
    }
    
    void helper(TreeNode* root){
        if ( root == NULL) return;
        
        helper(root->left);
        if ( prev != NULL and prev->val >= root->val){
            if ( first == NULL){
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
};