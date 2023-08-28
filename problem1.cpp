/*
// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
connecting the right node to the different parent of the left node.


// Your code here along with comments explaining your approach
Have two iterators one for level and one for current node
For each current node in the level node, 
Join its left to the right if left exists
if curr->next exists
Then join curr->right with curr->next->left
Move onto next current element in the level
Once iterateed all the elements move onto the next level
Repeat the process until there are no children of the given level node.
*/

// using BFS

#include<iostream>
#include<vector>

using namespace std;

class Node{
    public:
        int val;
        Node* left;
        Node* right;
        Node* next;
        
        Node(): val(0),left(NULL),right(NULL),next(NULL){}
        Node(int _val): val(_val),left(NULL),right(NULL),next(NULL){}
        Node(int _val,Node* _left,Node* _right): val(_val),left(_left),right(_right),next(NULL){}
};

class Solution {
public:
    Node* connect(Node* root) {
        if(root == NULL) return root;
        Node* level{root};
        while(level->left){
            Node* curr{level};
            while(curr){
                curr->left->next = curr->right;
                if(curr->next){
                    curr->right->next = curr->next->left;
                }
                curr = curr->next;
            }
            level = level->left;
        }
        return root;
    }
};

//using DFS

// space : O(H) ->height of the tree.

class Solution {
    void dfs(Node* node){
        //base
        if(node->left == NULL){
            return;
        }

        //logic
        //root
        node->left->next = node->right;
        if(node->next){
            node->right->next = node->next->left;
        }
        //left
        dfs(node->left);
        //right
        dfs(node->right);
    }
public:
    Node* connect(Node* root) {
        if(root == NULL) return root;
        dfs(root);
        return root;
    }
};