// Time Complexity : O(n)
// Space Complexity : O(1)

// Three line explanation of solution in plain english
/* Maintain pointer to left most child of current level.
 * Maintain a current pointer to iterate over level nodes.
 * While iterating establish links between the child nodes using current pointer. 
 */

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
        if (root == nullptr)
            return nullptr;
        
        Node *level, *current; 
        level = current = root;
        
        while (level->left != nullptr)
        {
            current = level;
            while (current != nullptr)
            {
                current->left->next = current->right;
                
                if (current->next != nullptr)
                {
                    current->right->next = current->next->left;
                }
                
                current = current->next;
            }
            
            level = level->left;
        }
        
        return root;
    }
};