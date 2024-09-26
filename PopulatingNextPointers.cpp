// Approach - BFS 
// Time Complexity - O(n)
// Space Complexity - O(h)
// Problems Faced - No!
// It runs on Leetcode - Yes!
class Solution {
public:
    Node* connect(Node* root) {
        if(!root)
            return root;
        queue<Node*> q;
        q.push(root);
        
        while(!q.empty()){
            Node* prev;
            int size = q.size();
            for(int i = 0; i < size; i++){
                Node* curr = q.front(); q.pop();
                if(i != 0){
                    prev->next = curr;
                }
                if(curr->left){
                    q.push(curr->left);
                    q.push(curr->right);
                }
                prev = curr;
            }
        }
        return root;
    }
};

// Approach - Optimised BFS (without using a queue for a level)
// Time Complexity - O(n)
// Space Complexity - O(1)
// Problems Faced - No!
// It runs on Leetcode - Yes!
class Solution {
public:
    Node* connect(Node* root) {
        if(!root)
            return root;
        Node* level = root;
        
        while(level->left){
            Node* curr = level;
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

// Approach - DFS(Pattern - Mirror)
// Time Complexity - O(n)
// Space Complexity - O(1), ignoring recursive stack space.
// Problems Faced - No!
// It runs on Leetcode - Yes!
class Solution {
    private:
    void dfs(Node* left, Node* right){
        // base
        if(!left)
            return;
        // logic
        left->next = right;
        dfs(left->left, left->right);
        dfs(left->right, right->left);
        dfs(right->left, right->right);
    }
public:
    Node* connect(Node* root) {
        if(!root)
            return root;
        dfs(root->left, root->right);
        return root;
    }
};

// Approach - DFS(Pre-order processing)
// Time Complexity - O(n)
// Space Complexity - O(1), ignoring recursive stack space.
// Problems Faced - No!
// It runs on Leetcode - Yes!
class Solution {
    private:
    void dfs(Node* root){
        // base
        if(!root->left)
            return;
        // logic
        root->left->next = root->right;
        if(root->next)
            root->right->next = root->next->left;
        dfs(root->left);
        dfs(root->right);
    }
public:
    Node* connect(Node* root) {
        if(!root)
            return root;
        dfs(root);
        return root;
    }
};