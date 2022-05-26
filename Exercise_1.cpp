/* 
    Time Complexity                              :  O(N)
    Space Complexity                             :  levelOrderIterative - O(max number of nodes on any level)
                                                    levelOrderRecursive - O(max number of nodes on any level)
                                                    usingNextPointer - O(1)
    Did this code successfully run on Leetcode   :  Yes
    Any problem you faced while coding this      :  No
*/

#include <bits/stdc++.h> 
using namespace std;  

// https://leetcode.com/problems/populating-next-right-pointers-in-each-node

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
public:
    Node* connect(Node* root) {
        if(!root) return root;
        // return levelOrderIterative(root);
        // return usingNextPointer(root);
        queue<Node*> q;
        q.push(root);
        levelOrderRecursive(q);
        return root;
    }
    
    Node* levelOrderIterative(Node *root) {
        queue<Node*> q;
        q.push(root);
        Node *start = root;
        while(!q.empty()) {
            int sz = q.size();
            for(int i=0;i<sz;i++) {
                Node *curr = q.front();
                q.pop();
                if(i+1 == sz)
                    curr->next = NULL;
                else 
                    curr->next = q.front();
                
                if(curr->left)
                    q.push(curr->left);
                if(curr->right)
                    q.push(curr->right);
            }
        }
        return start;
    }
    
    void levelOrderRecursive(queue<Node*> q) {
        int sz = q.size();
        if(sz == 0) return;
        for(int i=0;i<sz;i++) {
            Node *head = q.front();
            q.pop();
            
            if(i+1 == sz)
                head->next = NULL;
            else
                head->next = q.front();
            
            if(head->left) q.push(head->left);
            if(head->right) q.push(head->right);
        } 
        
        levelOrderRecursive(q);
       
    }
    
    Node* usingNextPointer(Node *root) {
        Node *leftmost = root;
        while(leftmost->left != NULL) {
            Node *head = leftmost;
            while(head != NULL) {
                head->left->next = head->right;
                if(head->next != NULL)
                    head->right->next = head->next->left;
                head = head->next;
            }
            leftmost = leftmost->left;
        }
        
        return root;
    }
};