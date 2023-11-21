private:
    void MorrisInorder(TreeNode* root){
        TreeNode* curr = root;
        while(curr!=NULL){
            if(curr->left==NULL){
                cout<<curr->val<<endl;
                curr = curr->right;
            }
            else{
                TreeNode* pre = curr->left;
                while(pre->right!=NULL && pre->right!=curr){
                    pre = pre->right;
                }
                if(pre->right==NULL){
                    pre->right = curr;
                    curr = curr->left;
                }
                else{
                    pre->right=NULL;
                    cout<<curr->val<<endl;
                    curr = curr->right;
                }

            }
        }
    }
