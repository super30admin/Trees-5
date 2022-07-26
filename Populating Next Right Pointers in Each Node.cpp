//Time Complexity- O(n)
//Space Complexity- O(1) //Stack space doesn't count as mentioned in the constraints

class Solution {
public:
    Node* connect(Node* root) {
        
        if(root==NULL){
            return root;
        }
        root->next=NULL;
        dfs(root);
        return root;
    }
    
    void dfs(Node* root){
        if(root==NULL){
            return;
        }
        
        Node* left=root->left;
        Node* right=root->right;
        Node* next=root->next;
        if(left){
            left->next=right;
            if(next){
                right->next=next->left;
            }
            dfs(left);
            dfs(right);
        }
    }
};