//Time O(n)
 //Space O(n)
 //Leetcode =yes
 //issue seen; none
class Solution {
public:
    void recoverTree(TreeNode* root) {
        stack<TreeNode*> st;
        TreeNode *prev = NULL, *x = NULL, *y = NULL;

        while (!st.empty() || root != NULL) {
            while (root) {
                st.push(root);
                root = root->left;
            }

            root = st.top();
            st.pop();
            if (prev != NULL && root->val < prev->val) {
                y = root;
                if (x == NULL) {
                    x = prev;
                } else {
                    break;
                }
            }
            prev = root;
            root = root->right;
        }
        if (x && y) {
            swap(x->val, y->val);
        }
    }
};
