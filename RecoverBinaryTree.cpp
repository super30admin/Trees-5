// Time Complexity : O(n)
// Space Complexity : O(h) Where h is height of tree.

// Three line explanation of solution in plain english
/* Perform inorder traversal over tree. While performing traversal maintain current and previous pointer.
 * Previous pointer value should always be less than the current pointer value. If it is not then record the pointer locations.
 * At the end of traversal, swap the node values of these captured two pointers.
 */

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
    void recoverTree(TreeNode* root) {
        
        TreeNode *first, *second, *current, *prev;
        first = second = prev = nullptr;
        stack<TreeNode*> stk;
        current = root;
        
        while (current != nullptr || !stk.empty())
        {
            while (current != nullptr)
            {
                stk.push(current);
                current = current->left;
            }
            
            current = stk.top();
            stk.pop();
            
            if (prev != nullptr && prev->val >= current->val)
            {
                if (first == nullptr)
                {
                    first = prev;
                    second = current;
                }
                else
                {
                    second = current;
                }
            }
            
            prev = current;
            current = current->right;
        }
        
        int tmp;
        
        if (first != nullptr && second != nullptr)
        {
            tmp = first->val;
            first->val = second->val;
            second->val = tmp;
        }
    }
};