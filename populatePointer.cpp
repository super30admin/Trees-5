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
        if(root == nullptr) return root; 
        bfs(root);
        return root; 
    }

    void bfs(Node* root) {
        deque<Node*> q; 

        if(root->left != nullptr) q.push_back(root->left);
        if(root->right != nullptr) q.push_back(root->right);

        root->next = nullptr; 

        while(!q.empty()) {
            int s = q.size(); 
            while(s > 0) {
                Node* firstNode = q.front(); 
                q.pop_front(); 
                if(s-1 > 0) {
                    firstNode->next = q.front(); 
                } else firstNode->next = nullptr; 

                if(firstNode->left != nullptr) q.push_back(firstNode->left);
                if(firstNode->right != nullptr) q.push_back(firstNode->right);
                s--; 
            }
        }
    }
};