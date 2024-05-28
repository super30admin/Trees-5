//Time O(n)
 //Space O(n)
 //Leetcode : yes
 //Issue seen: none
class Solution {
public:
    vector<int> inorderTraversal(TreeNode* root) {
        vector<int> ans;
        if(root==nullptr) return ans;
        stack<TreeNode*> s;
        while(root || !s.empty()){
            
            while(root !=nullptr) {
                s.push(root);
                root = root->left;
            }
            root=s.top();
            s.pop();
            ans.push_back(root->val);
            
            root = root->right;
        }
        return ans;
    }
};
