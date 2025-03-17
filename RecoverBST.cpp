// Time Complexity: O(n)
// Space Complexity: O(h) where h is the height of the tree
// Did this code successfully run on Leetcode : Yes

// Approach: 
// 1. We will do an inorder traversal of the tree and keep track of the previous node.
// 2. If the current node is less than the previous node, we will mark the first node as the previous node and the last node as the current node.
// 3. If we find another node which is less than the previous node, we will update the last node to the current node.
// 4. After the traversal, we will swap the values of the first and last node.

class Solution {
    TreeNode* first = nullptr, *last = nullptr, *prev = nullptr;
    bool flag = false;
public:
    void recoverTree(TreeNode* root) {
        inorder(root);
        //swap
        int temp = first -> val;
        first -> val = last -> val;
        last -> val = temp;
    }
    void inorder(TreeNode* root){
        if(root == nullptr){return;}
        inorder(root -> left);
        if(prev != nullptr && root -> val < prev -> val){
            if(flag == false){
                flag = true;
                first = prev;
                last = root;
            }else{
                last = root;
            }
        }
        prev = root;
        inorder(root -> right);
    }
};