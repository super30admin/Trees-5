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
        queue<Node*> q;
        q.push(root);
        if (root==NULL) return root;
        while (!q.empty()) {
            int size=q.size();
            vector<Node*> v;
            while(size--) {
                auto temp=q.front();
                q.pop();
                
                if (temp->left!=NULL) {
                    q.push(temp->left);
                    v.push_back(temp->left);
                }
                if (temp->right!=NULL) {
                    q.push(temp->right);
                    v.push_back(temp->right);
                }
            }
            for (int i=1;i<v.size();i++) {
                v[i-1]->next=v[i];
            }
        }
        return root;
    }
};