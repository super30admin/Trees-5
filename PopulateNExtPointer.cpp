// Time Complexity : O(N) where N=Number of nodes
// Space Complexity : O(N) for Brute Force and O(1) for Optimal solution
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
//This problem is solved using level order traversal.


class Solution {
public:
    Node* connect(Node* root) {
//BruteForce approach   
        
//         if(root == NULL) return NULL;
//         queue<Node*> q;
//         q.push(root);
        
//         while(!q.empty()){
//             int size = q.size();
//             for(int i=0;i<size;i++){
//                 Node* curr = q.front();
//                 q.pop();
//                 if(i<size-1){
//                     curr->next = q.front();
//                 }else{
//                     curr->next = NULL;
//                 }
//                 if(curr->left!=NULL){
//                     q.push(curr->left);
//                 }
//                 if(curr->right!=NULL){
//                     q.push(curr->right);
//                 }
//             }
//         }
//         return root;
        
//Without extra space Solution     
        if(root == NULL) return NULL;
        Node* level = root;
        while(level->left!=NULL){
            Node* curr = level;
            while(curr!=NULL){
                curr->left->next = curr->right;
                if(curr->next!=NULL){
                    curr->right->next = curr->next->left;
                }
                curr = curr->next;
            }
            level = level->left;
        }
        return root;
        
    }
};
