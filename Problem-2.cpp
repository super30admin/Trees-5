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
 Time Complexity = O(n)
 Space Complexity = O(h)
 where n is the number of nodes and h is the height of the tree.
 */
class Solution {
public:
    TreeNode* first=NULL; 
    TreeNode* last=NULL;
    TreeNode* prev=NULL;
    bool mismatch=false;
    void dfs(TreeNode* root)
    {
        //base
        if(root==NULL)
            return;
        //logic
        dfs(root->left);
        if(prev!= NULL && prev->val>=root->val){
            if(!mismatch){
                first = prev;
                last=root;
                mismatch=true;
            }
            else{
                last = root;
                return;
            }
        }
        prev = root;
        dfs(root->right);
    }
    void recoverTree(TreeNode* root) {
        dfs(root);
        int temp = first->val;
        first->val = last->val;
        last->val = temp;
    }
};
