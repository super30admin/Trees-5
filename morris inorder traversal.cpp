//try iterative as well - stack over the hood
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

//iterative
/*
class Solution {
public:
    vector<int> inorderTraversal(TreeNode* root) {
        vector<int> result;
        stack<TreeNode*> st;
        while(!st.empty() || root != NULL) {
            while(root != NULL) {
                st.push(root);
                root = root -> left;
            }
            root = st.top();
            st.pop();
            result.push_back(root -> val);
            root = root -> right;
        }
        return result;
    }
};
*/

//morris algo - without a stack (it is like make a binary tree into a LL)
//time: O(n*height), amortized - O(n)
//space: O(1)
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