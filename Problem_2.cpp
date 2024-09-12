//Time Comp: O(N)
//Space Comp: O(1)
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
TreeNode* first;
TreeNode* last;
TreeNode* prev;
bool flag;
private:
    void inorder(TreeNode* root){
        if(root == nullptr){
            return;
        }
        inorder(root->left);
        if(prev!= nullptr && root->val <= prev->val){
            if(!flag){
                first = prev;
                last = root;
                flag = true;
            }
            else{
                last = root;
            }
        }
        prev = root;
        inorder(root->right);
    }
public:
    void recoverTree(TreeNode* root) {
        if(root == nullptr) return ;
        inorder(root);
        int temp = last->val;
        last->val = first->val;
        first->val = temp;
    }
};