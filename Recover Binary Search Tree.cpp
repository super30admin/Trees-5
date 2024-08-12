//time: O(n)
//space: O(h)
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
    TreeNode* prev = NULL;
    TreeNode* a = NULL; // first
    TreeNode* b = NULL; // second
    bool flag = false;
    void inorder (TreeNode* root) {
        if(root == NULL) {
            return;
        }
        inorder(root -> left);
        if(prev != NULL && root -> val <= prev -> val) {
            if(a == NULL) {
                a = prev;
                b = root;
                //flag = true;
            }
            else {
                b = root;
                flag = true;
            }
        }
        prev = root;
        if(!flag) inorder(root -> right);
    }
public:
    void recoverTree(TreeNode* root) {
        inorder(root);
        int temp = a->val;
        a->val = b->val;
        b->val = temp;
    }
};