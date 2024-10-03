// time complexity - O(n) space complexity - O(1)
class Solution {
public:
    vector<int> inorderTraversal(TreeNode* root) {
        vector<int> result;
        while(root != NULL) {
            if(root -> left == NULL) {
                result.push_back(root -> val);
                root = root -> right;
            }
            else {
                TreeNode* pre = root -> left;
                while(pre -> right != NULL && pre -> right != root) {
                    pre = pre -> right;
                }
                if(pre -> right == NULL) {
                    pre -> right = root;
                    root = root -> left;
                }
                else {
                    pre -> right = NULL;
                    result.push_back(root -> val);
                    root = root -> right;
                }
            }
        }
        return result;
    }
};