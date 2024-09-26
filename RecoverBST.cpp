// Recursive Solution
// Time Complexity - O(n)
// Space Complexity - O(h)
// Problems Faced - No!
// It runs on Leetcode - Yes!
class Solution {
    TreeNode* prev = nullptr;
    TreeNode* first = nullptr;
    TreeNode* second = nullptr;
    private:
    void inorder(TreeNode* root){
        // base
        if(root == NULL)
            return;
        
        // logic
        inorder(root->left);
        if(prev && prev->val >= root->val){
            if(!first){
                first = prev;
                second = root;
            }
            else
                second = root;
        }
        prev = root;
        inorder(root->right);
    }
public:
    void recoverTree(TreeNode* root) {
        if(!root)
            return;
        inorder(root);
        int temp = first->val;
        first->val = second->val;
        second->val = temp;
    }
};

// Iterative Solution
// Time Complexity - O(n)
// Space Complexity - O(h)
// Problems Faced - No!
// It runs on Leetcode - Yes!
class Solution {
    
    TreeNode* first;
    TreeNode* second;
    private:
    void inorder(TreeNode* root){
        TreeNode* prev = NULL;
        stack<TreeNode*> st;
        while(root || !st.empty()){
            while(root){
                st.push(root);
                root = root->left;
            }
            root = st.top(); st.pop();
            if(prev && prev->val >= root->val){
                if(!first){
                    first = prev;
                    second = root;
                }
                else
                    second = root;
            }
            prev = root;
            root = root->right;
        }
    }
public:
    void recoverTree(TreeNode* root) {
        if(!root)
            return;
        inorder(root);
        int temp = first->val;
        first->val = second->val;
        second->val = temp;
    }
};