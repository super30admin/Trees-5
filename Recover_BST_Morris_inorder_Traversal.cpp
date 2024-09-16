//Time Complexity-O(n)-->'n' is total number of nodes
//Space Complexity-O(1) 
//Did the code run on Leetcode? Yes

class Solution {
    public:
    void recoverTree(TreeNode* root) {
        if(root==NULL)
        {
            return;
        }
        TreeNode* prev=NULL;
        TreeNode* first=NULL;
        TreeNode* last=NULL;
        while(root!=NULL)
        {
            if(root->left==NULL)
            {
                if(prev!=NULL && prev->val>root->val)
                {
                    if(first==NULL)
                    {
                        first=prev;
                    }
                    last=root;
                }
                prev=root;
                root=root->right;
            }
            else
            {
                TreeNode* a=root->left;
                while(a->right!=NULL && a->right!=root)
                {
                    a=a->right;
                }
                if(a->right==NULL)
                {
                    a->right=root;
                    root=root->left;
                }
                else
                {
                    a->right=NULL;
                    if(prev!=NULL && prev->val>root->val)
                    {
                        if(first==NULL)
                        {
                            first=prev;
                        }
                        last=root;
                    }
                    prev=root;
                    root=root->right;
                }
            }
        }
        swap(first->val,last->val);
    }
};