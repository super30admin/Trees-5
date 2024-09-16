//Time Complexity-O(n)-->'n' is the number of nodes
//Space Complexity-O(1)
//Did the code execute on Leetcode? Yes

class Solution {
public:
    
    void recover(TreeNode* root,TreeNode*& prev,TreeNode*& first,TreeNode*& last)
    {
        if(root==NULL)
        {
            return;
        }
        recover(root->left,prev,first,last);
        if(prev!=NULL && prev->val>root->val)
        {
            if(first==NULL)
            {
                first=prev;
            }
            last=root;
        }
        prev=root;
        recover(root->right,prev,first,last);
    }
    void recoverTree(TreeNode* root) {
        TreeNode* first=NULL;
        TreeNode* prev=NULL;
        TreeNode* last=NULL;
        recover(root,prev,first,last);
        swap(first->val,last->val);
    }
};