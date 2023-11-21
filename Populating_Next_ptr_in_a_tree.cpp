//DFS Solution Optimised
class Solution {
public:
    Node* connect(Node* root) {
        if(root==NULL)return NULL;
        dfs(root);
        return root;
    }
private:
    void dfs(Node* root){
        if(root->left==NULL)return;
        //logic
        root->left->next = root->right;
        if(root->next!=NULL){
            root->right->next = root->next->left;
        }
        dfs(root->left);
        dfs(root->right);
    }
};

//DFS Solution Optimised
class Solution {
public:
    Node* connect(Node* root) {
        if(root==NULL)return NULL;
        dfs(root->left, root->right);
        return root;
    }
private:
    void dfs(Node* left, Node* right){
        //base
        if(left == NULL)return;
        //logic
        left->next = right;
        dfs(left->left, left->right);
        dfs(right->left, right->right);
        dfs(left->right, right->left);
    }    
};

//DFS Solution Not Optimised
class Solution {
public:
    Node* connect(Node* root) {
        vector<Node*> li;
        helper(root, 0, li);
        return root;
    }
private: 
    void helper(Node* root, int level, vector<Node*>& li){
        //base case
        if(root==NULL)return;

        if(level==li.size()){
            li.push_back(root);
        }
        else{
            root->next = li[level];
            li[level] = root; 
        }
        //logic
        helper(root->right, level+1, li);
        helper(root->left, level+1, li);
        
    }
};


//Bfs Solution - Optimised
class Solution {
public:
    Node* connect(Node* root) {
        if(root == NULL)return NULL;
        Node* level = root;
        while(level->left!=NULL){
            Node* curr = level;
            while(curr!=NULL){
                curr->left->next = curr->right;
                if(curr->next!=NULL){
                    curr->right->next = curr->next->left;
                }
                curr = curr->next;
            }
        level = level->left;
        }
        return root;
    }
};





//Bfs Solution - Not Optimised
class Solution {
public:
    Node* connect(Node* root) {
        if(root ==NULL)return NULL;
        queue<Node*>q;
        q.push(root);
        while(!q.empty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                Node *curr = q.front();
                q.pop();
                if(i!=size-1){
                    curr->next = q.front();
                }
                if(curr->left!=NULL){
                    q.push(curr->left);
                    q.push(curr->right);
                }
            }
        }

        return root;
    }
};
