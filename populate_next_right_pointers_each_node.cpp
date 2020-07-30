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

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Your code here along with comments explaining your approach
//1. Iterate through left and right portion of the node.
//2. Connect left and right nodes, connect right node with last node
//3. Recurse on left node unconditionally
//4. Recurse on right node with extra check whether the last node  is NUll or not
class Solution {
public:
    Node* connect(Node* root) {
        //edge
        if(root==NULL) return NULL;
        //logic
        connecting_per_level(root->left, root->right, NULL);
        return root;
    }
    
    void connecting_per_level(Node* left_node, Node* right_node, Node* last_node){
        //return condition
        if(left_node ==NULL || right_node ==NULL) return;
        //logic
        //1. Connect left and right nodes
        //2. Connect right node with last node
        left_node->next = right_node;
        right_node->next = last_node;
        //recurse
        //left : Since complete BST we know right_node->left exists
        connecting_per_level(left_node->left, left_node->right, right_node->left);
         //right : Connect to the next node if the child of next node exist, else terminate it. 
        if(last_node !=NULL) last_node = last_node->left;
        connecting_per_level(right_node->left, right_node->right, last_node);
    }
};
