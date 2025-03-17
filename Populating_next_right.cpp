// Time Complexity: O(n)
// Space Complexity: O(1)
// Did this code successfully run on Leetcode : Yes

// Approach:
// 1. We initialize a level node to the root of the tree.
// 2. We will iterate over the tree level by level.
// 3. For each level, we will iterate over the nodes in that level.
// 4. If the current node has a left child, we will connect the left child to the right child.
// 5. If the current node has a right child and a next node, we will connect the right child to the left child of the next node.
// 6. We will update the current node to the next node and continue the process.


class Solution {
    public:
        Node* connect(Node* root) {
            if(root == nullptr){return nullptr;}
    
            Node* level = root;
    
            while(level != nullptr){
                Node* curr = level;
                while(curr != nullptr){
                    if(curr -> left != nullptr){
                        curr -> left -> next = curr -> right;
                    }
                    if(curr -> right != nullptr && curr -> next != nullptr){
                        curr -> right -> next = curr -> next -> left;
                    }
                    curr = curr -> next;
                }
                level = level -> left;
            }
            return root;
        }
    };