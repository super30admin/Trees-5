/**
 * @Time complexity:
 * O(N) in worst case when one of the swapped nodes is the rightmost leaf
*/

/**
 * @Space Complexity:
 * O(N) because of the stack in worst case scenario
 */


// The code ran perfectly on leetcode.

class Solution {
    
        TreeNode* first = NULL;
        TreeNode* second = NULL;
        TreeNode* prev;
   
public:
    void recoverTree(TreeNode* root) {
        //if(root == NULL) return;
        inorder(root);
        swap(first->val, second->val);
        
    }
    private:
    void inorder(TreeNode* root){
        if(root== NULL) return;
        
        inorder(root->left);
        if(prev != NULL && prev->val >= root->val){
            if(second == NULL && first == NULL){
                first = prev;
                second = root;
            } else {
                second = root;
            }
            
        }
        prev = root;
        inorder(root->right);
    }
};