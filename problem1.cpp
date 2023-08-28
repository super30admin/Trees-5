
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

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
// Space Complexity : O(n) at max there will be two levels of nodes which is less than n ==> 2^h-1 + 2^h nodes
// Did this code successfully run on Leetcode :yes

// Level order traversal 

class Solution {
public:
    Node* connect(Node* root) {
        if(root==NULL) return root;
        queue<Node*>q;
        q.push(root);
        while(!q.empty()){
            int n = q.size();
            for(int i = 0;i<n;i++){
                Node* p = q.front();q.pop();
                if(i<n-1) p->next = q.front();
                if(p->left) q.push(p->left);
                if(p->right) q.push(p->right);
            }
        }
        return root;
        
    }
};
// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode :yes

class Solution {
public:
    void dfs(Node* left,Node* right){
        if(left == NULL) return ;
        left->next = right;
        dfs(left->left,left->right);
        dfs(left->right,right->left);
        dfs(right->left,right->right);
    }
    Node* connect(Node* root) {
        if(root == NULL) return root;
        dfs(root->left,root->right);
        return root;
    }
};

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :yes

class Solution {
public:
    Node* connect(Node* root) {
        if(root==NULL || root->left==NULL) return root;
        Node* left = root;
        Node* curr = NULL;
        while(left->left!=NULL)
        {
            curr = left;
            while(curr!=NULL){
                curr->left->next = curr->right;
                if(curr->next){
                    curr->right->next = curr->next->left;
                }
                curr = curr->next;
            }
            left = left->left;
        }
        return root;
    }
};