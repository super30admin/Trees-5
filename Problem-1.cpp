class Solution {
public:
 
    Node* connect(Node* root) {
    if (root == nullptr) {
      return nullptr;
    }
    if(root->left){
            root->left->next = root->right;
            root->right->next = root->next? root->next->left : NULL;
        }
        connect(root->left);
        connect(root->right);
    
    return root;
    }
        
};
