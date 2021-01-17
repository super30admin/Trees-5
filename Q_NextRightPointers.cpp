
//## Problem1 Populating Next Right Pointers in Each Node
//(https://leetcode.com/problems/populating-next-right-pointers-in-each-node/

//TC- O(n) as traversing all nodes (level order traversal)
//SC- O(n) as queue will contain all nodes

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
        
        if(root==NULL){
            return NULL;
        }
        
        queue<Node*> q1;
        q1.push(root);
        
        while(!q1.empty()){
            int s= q1.size();
            for(int i=0; i< s ;i++){
                Node* ele = q1.front();
                q1.pop();
                if( i != s-1 ){
                    ele->next= q1.front();
                }
                if(ele->left != NULL){
                    q1.push(ele->left);
                }
                if(ele->right != NULL){
                    q1.push(ele->right);
                }
            }
        }
      return root;  
    }
};

//BFS level order
//TC - O(n)
//SC -O(1)

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
    Node* connect(Node* root) 
    {
        if(root == NULL)
        {
            return NULL;
        }
        Node* level = root;
        while(level->left != NULL)
        {
            Node* curr =level;
            while(curr != NULL)
            {
                curr->left->next = curr->right; 
                if(curr->next != NULL)
                {
                     curr->right->next = curr->next->left;
                }
                curr= curr->next;
                
            }
           level = level->left;  
        }
    return root;
    }
};


//DFS