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
Time Coplexity = O(N)
Space Complexity = O(N)
where n is the number of nodes in the tree.
*/

class Solution {
public:
    Node* connect(Node* root) {
        if(root==NULL)
            return NULL;
        queue<Node*> q;
        q.push(root);
        int size,i;
        while(!q.empty()){
            size = q.size();
            Node* prev = q.front();
            q.pop();
            if(prev->left!=NULL)
            {
                q.push(prev->left);
                q.push(prev->right);
            }
            for(i=1;i<size;i++){
                Node* curr = q.front();
                q.pop();
                if(curr->left!=NULL){
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
Time Coplexity = O(N)
Space Complexity = O(h)
where n is the number of nodes in the tree.
*/

class Solution {
public:
    void dfs(Node* left, Node* right)
    {
        //base
        if(left==NULL)
            return;
        //logic
        left->next = right;
        dfs(left->left, left->right);
        dfs(left->right, right->left);
        dfs(right->left, right->right);
    }
    Node* connect(Node* root) {
        if(root==NULL)
            return NULL;
        dfs(root->left,root->right);
        return root;
    }
};

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
Time Coplexity = O(N)
Space Complexity = O(1)
where n is the number of nodes in the tree.
*/

class Solution {
public:
    Node* connect(Node* root) {
        if(root==NULL)
            return NULL;
        Node* lvl=root;
        Node* curr;
        while(lvl->left!=NULL)
        {
            curr=lvl;
            while(curr!=NULL)
            {
                curr->left->next = curr->right;
                if(curr->next!=NULL){
                    curr->right->next = curr->next->left;
                }
                curr=curr->next;
            }
            lvl=lvl->left;
        }
        return root;
    }
};
