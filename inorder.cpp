// Time Complexity: O(n)
// Space Complexity: O(h) where h is the height of the tree
// Did this code successfully run on Leetcode : Yes

// Approach:
// 1. We will do an inorder traversal of the tree using a stack.
// 2. We will push the left child of the current node into the stack until we reach the leftmost node.
// 3. We will pop the top element from the stack and add it to the result.
// 4. We will move to the right child of the current node and repeat the process.

class Solution {
    public:
        vector<int> inorderTraversal(TreeNode* root) {
            vector<int> result; 
            stack<TreeNode*> stack; 
            TreeNode* curr = root;
            while(curr != nullptr || !stack.empty()){
                while(curr != nullptr){
                    stack.push(curr);
                    curr = curr -> left;
                }
                curr = stack.top();
                stack.pop();
                result.push_back(curr -> val);
                curr = curr -> right;
            }
            return result;
        }
    };