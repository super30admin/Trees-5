//time: O(n) space: O(h)
class Solution {
public:
    Node* connect(Node* root) {
        if(root == NULL) return NULL;
        dfs(root -> left, root -> right);
        return root;
    }
private:
    void dfs(Node* left, Node* right) {
        if(left == NULL) return; // no need to check right because perfect binary tree
        left -> next = right;
        dfs(left -> left, left -> right);
        dfs(left -> right, right -> left);
        dfs(right -> left, right -> right);
    }
};