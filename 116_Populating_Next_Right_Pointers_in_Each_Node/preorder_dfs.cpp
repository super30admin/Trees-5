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
        vector<Node*> levelPtrs;
        preorder(root, levelPtrs, 0);
    }

    void preorder(Node* root, vector<Node*> &levelPtrs, int level) {
        if(root == nullptr) {
            return;
        }
        if(levelPtrs.size() <= level) {
            levelPtrs.push_back(root);
        }
        else {
            levelPtrs[level]->next = root;
            levelPtrs[level] = root;
        }
        preorder(root->left, levelPtrs, level+1);
        preorder(root->right, levelPtrs, level+1);
    }
};
