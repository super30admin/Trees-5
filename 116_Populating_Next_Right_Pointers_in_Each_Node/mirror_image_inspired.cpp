#include<bits/stdc++.h>
using namespace std;

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

class Solution {
public:
    Node* connect(Node* root) {
        if(root == nullptr) {
            return root;
        }
        vector<Node*> levelPtrs;
        mirrorImage(root->left, root->right);
        return root;
    }

    void mirrorImage(Node* left, Node* right) {
        if(left == nullptr) {
            return;
        }

        // Do
        left->next = right;
        // Recurse
        mirrorImage(left->left, left->right);
        mirrorImage(left->right, right->left);
        mirrorImage(right->left, right->right);
    }
};
