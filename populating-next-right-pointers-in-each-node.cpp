//Time - O(n)
//Space - O(logn)
class Solution {
public:
    Node* connect(Node* root) {
        if(root==NULL) return NULL;
        root->next = NULL;
        connectAllNodes(root);
        return root;
    }
    
    void connectAllNodes(Node* root){
        if(root->left == NULL) return;
        root->left->next = root->right;
        if(root->next == NULL) root->right->next = NULL;
        else {
            root->right->next = root->next->left;
        }
        connectAllNodes(root->left);
        connectAllNodes(root->right);
    }
};