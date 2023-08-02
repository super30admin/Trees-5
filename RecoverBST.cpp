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
    vector<TreeNode*> inorder; 
    void recoverTree(TreeNode* root) {
        inorderT(root);

        for(int i = 0; i < inorder.size(); i++) {
            cout << inorder[i]->val << " , ";
        }

        cout << endl; 

        for(int i = 0; i < inorder.size(); i++) {
            int minVal = inorder[i]->val;
            for(int j = i+1; j < inorder.size(); j++) {
                int jVal = inorder[j]->val; 
                if(jVal < minVal) {
                    inorder[i]->val = jVal; 
                    inorder[j]->val = minVal; 
                    minVal = jVal; 
                }
            }
        }       
    }

    void inorderT(TreeNode* root) {
        if(root == nullptr) return; 
        inorderT(root->left);
        inorder.push_back(root);
        inorderT(root->right);
    }
};