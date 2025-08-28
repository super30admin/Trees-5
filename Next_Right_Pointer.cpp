//Time Cpmplexity :O(n)
//Space Compelxity :O(1)
#include<iostream>
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

class Solution {
public:
    Node* connect(Node* root) {
        if(root == nullptr) return nullptr;
        Node* d = root;
        while(d->left != nullptr){
            Node* curr = d;
            while(curr != nullptr){
                curr->left->next = curr->right;
                if(curr->next != nullptr){
                    curr->right->next = curr->next->left;
                }
                curr = curr->next;
            }
            d = d->left;
        }

        return root;
    }
};