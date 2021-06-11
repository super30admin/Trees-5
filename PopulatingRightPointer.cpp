/**
Intuition:
#####################################################################
Solution 1: Do level order traversal, in each level, assign the curr popped node to the next element in the queue.
Time Complexity : O(N), N = Number of nodes in the tree
Space Complexity : O(N/2), N/2 = Number of leaf nodes.
#####################################################################
Solution 2: Keep assing the next pointer using the left and right properties of the nodes.
Time Complexity : O(N), N = Number of nodes in the tree
Space Complexity : O(1), H = Height of the tree
#####################################################################
*/

//Solution 1
class Solution {
public:
    Node* connect(Node* root) {
        queue <Node*> queue;
        if ( root == NULL) return root;
        queue.push(root);
        
        Node* curr = NULL;
        Node* nextPointer = NULL;
        while ( queue.size()!= 0){
            int size = queue.size();
            for ( int i =0; i < size; i++){
                
                curr = queue.front();
                queue.pop();
                
                if ( i == size-1){
                    curr->next = NULL;
                }
                else{
                    nextPointer = queue.front();
                    curr->next = nextPointer;
                }
                
                if (curr->left != NULL) queue.push(curr->left);
                if (curr->right != NULL) queue.push(curr->right);
                
            }
        }
        return root;
    
    }
};

//Solution 2
class Solution {
public:
    Node* connect(Node* root) {
        if ( root == NULL) return NULL;
        Node* level = root;
        Node* curr;
        while ( level->left != NULL ){
            curr = level;
            while ( curr != NULL){

                curr->left->next = curr->right;
                if ( curr->next != NULL)
                    curr->right->next = curr->next->left;

                curr = curr->next;
            }
            level = level->left;
        }
        return root;
    }
};