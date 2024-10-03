//time: O(n) space: O(h)
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