// Time Complexity : O(N)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
public:
    Node* connect(Node* root) {
        if(root == NULL)
            return root;
        queue<Node*> q;
        q.push(root);
        while(!q.empty()){
            int size = q.size();
            Node* prev = q.front();
            q.pop();
            if(prev->left != NULL){
                q.push(prev->left);
                q.push(prev->right);
            }
            for(int i=1; i<size; i++){
                Node* curr = q.front();
                q.pop();
                if(curr->left != NULL){
                    q.push(curr->left);
                    q.push(curr->right);
                }
                prev->next = curr;
                prev = curr;
            }
        }
        return root;
    }
};

// Time Complexity : O(N)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
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


// Time Complexity : O(N)
// Space Complexity :O(H)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class Solution {
public:
    Node* connect(Node* root) {
        if(root == NULL)
            return root;
        dfs(root->left, root->right);
        return root;
    }
    
    void dfs(Node* left, Node* right){
        //base
        if(left == NULL)
            return;
        //logic
        left->next = right;
        dfs(left->left, left->right);
        dfs(left->right, right->left);
        dfs(right->left, right->right);
    }
};
