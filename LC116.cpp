
// Time complexity O(n)
// Space complexity O(logn)
/*
// Definition for a Node.
class Node {
public:
    int val;
    Node* left;
    Node* right;
    Node* next;

    Node() : val(0), left(NULL), right(NULL), next(NULL) {}

    Node(int _val) : val(_val), left(NULL), right(NULL), next(NULL) {}

    Node(int _val, Node* _left, Node* _right, Node* _next)
        : val(_val), left(_left), right(_right), next(_next) {}
};
*/

class Solution {
    void helper(Node* node)
    {
        if (node->left == nullptr) return;

        node->left->next = node->right;
        if (node->next != nullptr) 
        {
            node->right->next = node->next->left;
        }

        helper(node->left);
        helper(node->right); 
    }

public:
    Node* connect(Node* root) {
        if (root == nullptr) return root;
        helper(root);
        return root;
    }
};