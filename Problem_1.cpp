/**
 * @Time complexity:
 * O(N)
 * 
 */

/**
 * @Space Complexity:
 * O(1)
 * 
 */

/**
 * @Approach:
 * 
 * We are using the next pointer to establish the connection.
 * We move in the leftmost direction that is left child of the root.
 * we set this child as the new head. Until this head is not null,
 * we connect the head's left's next to head's right. If there is head's next,
 * we connect the head's right's next to head's next's left. Then we
 * move to the right with head's next and update the leftMost too.
 * 
 */

// The code ran perfectly on leetcode.

class Solution {
public:
    Node* connect(Node* root) {
        if(root == NULL){
            return NULL;
        }
        Node *leftMost = root;
        while(leftMost->left != NULL){
            Node *head = leftMost;
            while(head != NULL){
                head->left->next = head->right;
                if(head->next != NULL){
                    head->right->next = head->next->left;
                }
                head = head->next;
            }
            leftMost = leftMost->left;
        }
          
    return root;
  }
          
};