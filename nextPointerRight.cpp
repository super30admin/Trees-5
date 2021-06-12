// Time Complexity :O(n) where n in the number of nodes in a tree
// Space Complexity : O(1)  
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

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
        Node* level = root;
        Node* curr;
        while(level->left){
            curr = level;
            while(curr){
                curr->left->next = curr->right;
                if(curr->next) curr->right->next = curr->next->left;
                curr = curr->next;
            }
            level = level->left;
        }
        return root;
    }
};