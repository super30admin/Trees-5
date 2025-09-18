#include<iostream>
#include<bits/stdc++.h>
#include<vector>
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
/*
We use two pointers to connect the left and right children at each level.
Then we connect across subtrees by linking the right child of one node to the left child of the next.
This is done recursively across all levels.
*/
class Solution{
public:
    void dfs(Node* left, Node* right){
        if(left ==  nullptr) return;

        left->next = right;

        dfs(left->left, left->right);
        dfs(left->right, right->left);
        dfs(right->left, right->right);
    }
public:
    Node* connect(Node* root) {
        if(root == nullptr) return nullptr;
        dfs(root->left, root->right);
        return root;
    }
};
