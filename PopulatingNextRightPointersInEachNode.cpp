//Time Complexity O(n)
// Space Complexity O(h)
//Problem successfully executed on leetcode
//No problems faced while coading this.


#include<iostream>
#include<vector>
#include<queue>
#include<map>
#include<stack>
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
        if(root==NULL)
        {
            return root;
        }
        Node* curr=root;
        Node* level=root;
        
        while(level->left!=NULL)
        {    
            while(curr!=NULL)
            {
                (curr->left)->next=curr->right;
                if(curr->next!=NULL)
                {
                    (curr->right)->next=(curr->next)->left;
                }
                curr=curr->next;
            }
            
            level=level->left;
            curr=level;
        }
        return root;
    }
};