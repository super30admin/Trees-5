//bfs
//(1) normal (uses queue - n space)
//(2) consider each lvl as a LL (no space)
//dfs
//(1) inorder/preorder
//(2) as a symmetric tree - go on left and right together

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

//dfs (1)
/*
class Solution {
public:
    Node* connect(Node* root) {
        if(root == NULL) return NULL;
        dfs(root);
        return root;
    }
private:
    void dfs(Node* root) {
        if(root -> left == NULL) return; // no need to check right because perfect binary tree
        root -> left -> next = root -> right;
        //preorder
        if(root -> next != NULL) {
            root -> right -> next = root -> next -> left;
        }
        dfs(root -> left);
        dfs(root -> right);
    }
};
*/

//dfs (2)
//time: O(n)
//space: O(h)
class Solution {
public:
    Node* connect(Node* root) {
        if(root == NULL) return NULL;
        dfs(root -> left, root -> right);
        return root;
    }
private:
    void dfs(Node* left, Node* right) {
        if(left == NULL) return; // no need to check right because perfect binary tree
        left -> next = right;
        dfs(left -> left, left -> right);
        dfs(left -> right, right -> left);
        dfs(right -> left, right -> right);
    }
};

//bfs without space
/*
class Solution {
public:
    Node* connect(Node* root) {
        if(root == NULL) return NULL;
        Node* level = root;
        while(level -> left != NULL) {
            Node* curr = level;
            while(curr != NULL) {
                curr -> left -> next = curr -> right;
                if(curr -> next != NULL) {
                    curr -> right -> next = curr -> next -> left;
                }
                curr = curr -> next;
            }
            level = level -> left;
        }
        return root;
    }
};
*/