// Author: Subhed Chavan
// Batch: December 24
// Problem Statement: Recover Binary Search
// Approach: In-order Traversal (Morris Traversal)
// Time Complexity: O(N)
// Space Complexity: O(H)

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left),
 * right(right) {}
 * };
 */
class Solution {
    private:
        TreeNode* prev;
        TreeNode* first;
        TreeNode* second;
        int count;
    
    public:
        void recoverTree(TreeNode* root) {
            if (!root) {
                return;
            }
            prev = first = second = nullptr;
            count = 0;
            std::stack<TreeNode*> s;
    
            while (root || !s.empty()) {
                while (root) {
                    s.push(root);
                    root = root->left;
                }
                root = s.top();
                s.pop();
    
                if (prev && prev->val > root->val) {
                    count++;
                    if (!first) {
                        first = prev;
                    }
                    second = root;
                }
                if (count == 2) {
                    break;
                }
    
                prev = root;
                root = root->right;
            }
    
            if (first && second) {
                swap(first->val, second->val);
            }
        }
    };
    