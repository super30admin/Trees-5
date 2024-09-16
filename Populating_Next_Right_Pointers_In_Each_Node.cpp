//Time Complexity-O(n)-->'n' is number of nodes
//Space Complexity-O(1)
//Did the code run on Leetcode? yes

class Solution {
public:
    Node* connect(Node* root) {
        if(root==NULL)
        {
            return NULL;
        }
        Node* temp=root;
        while(temp->left!=NULL)
        {
            Node* curr=temp;
            while(curr!=NULL)
            {
                curr->left->next=curr->right;
                if(curr->next!=NULL)
                {
                    curr->right->next=curr->next->left;
                }
                curr=curr->next;
            }
            temp=temp->left;
        }
        return root;
    }
};