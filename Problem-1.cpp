// https://leetcode.com/problems/populating-next-right-pointers-in-each-node/description/
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

// bfs
class Solution {
    public:
        Node* connect(Node* root) {
            if(root == NULL) return NULL;
            Node* level = root;
            while(level->left != NULL){
                Node* curr = level;
                while(curr != NULL){
                    curr->left->next = curr->right;
                    if(curr->next != NULL) curr->right->next = curr->next->left;
                    curr = curr->next;
                }
                level = level->left;
            }
            return root;
        }
    };


// dfs
// Time Complexity : O(n)
// Space Complexity : O(n)

class Solution {
    public:
        void dfs(Node* left, Node* right){
            if(left == NULL) return;
            left->next = right;
            dfs(left->left, left->right);
            dfs(left->right, right->left);
            dfs(right->left, right->right);
        }
        Node* connect(Node* root) {
            if(root == NULL) return NULL;
            dfs(root->left, root->right);
            return root;
        }
    };
// Time Complexity : O(n)
// Space Complexity : O(n)

class Solution {
    public:
        void dfs(Node* root){
            if(root->left == NULL) return;
            root->left->next = root->right;
            if(root->next != NULL) root->right->next = root->next->left;
            dfs(root->left);
            dfs(root->right);
        }
        Node* connect(Node* root) {
            if(root == NULL) return NULL;
            dfs(root);
            return root;
        }
    };
