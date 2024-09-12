// Time Complexity : O(n) 
// Space Complexity : O(1) for BFS 2 Pointers / O(h) DFS recursive stack size
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No 

// Populate Next Right Pointers in a Tree


#include<iostream>

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


// BFS 2 Pointers

class Solution {
public:
    Node* connect(Node* root) {
        
        if(root == NULL)
            return root;
        
        Node* level = root;
        
        while(level->left != NULL){
            
            Node* curr = level;
            while(curr != NULL){
                curr->left->next = curr->right;
                if(curr->next != NULL)
                    curr->right->next = curr->next->left;
                    
                curr = curr->next;
            }
            
            level = level->left;
        }
        
        return root;
    }
};

//  DFS

class Solution {
public:
    Node* connect(Node* root) {
        if(root == NULL)
            return root;
        
        dfs(root->left, root->right);
        return root;
    }
    
    void dfs(Node* r1, Node* r2){       // every recursive call a connection is established
        //base
        if(r1 == NULL || r2 == NULL)  // for a complete binary tree, and if not complete check right as well
            return;
        
        //logic
        r1->next = r2;
        dfs(r1->left, r1->right);
        dfs(r1->right, r2->left);
        dfs(r2->left, r2->right);
    }
};