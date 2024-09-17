// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Your code here along with comments explaining your approach
//Approach with an extra space
//1. Do inorder traversal and create an array of all the elements
//2. Search for inconsistency. 
//3. If found at only one place swap the two immediate numbers.
//4. Else swap the first pointer and last pointer of second dicrepancy.

class Solution {
public:
    bool flag_first_swap = false;
    bool flag_second_swap = false;
    void recoverTree(TreeNode* root) {
        //edge
        if(root == NULL) return;
        
        //create inorder traversal array
        vector<TreeNode*> bst_array;
        inorder(root, bst_array);
        
        TreeNode*  first= new TreeNode(); TreeNode* second= new TreeNode();
        for(int i=1; i<bst_array.size();i++){
            if(flag_first_swap == false && bst_array[i-1]->val > bst_array[i]->val){
                first = bst_array[i-1];
                second = bst_array[i];
                flag_first_swap=true;
            }else if(flag_first_swap == true && bst_array[i-1]->val > bst_array[i]->val){
                second = bst_array[i];
                flag_second_swap=true;
            }
        }
            int temp = second->val;
            second->val =first->val;
            first->val = temp;
      
    }
    
    void  inorder(TreeNode* root,vector<TreeNode*> &bst_array){
        //returning condition
        if(root==NULL) return;
        //traverse through nodes
        inorder(root->left, bst_array);
        bst_array.push_back(root);
        inorder(root->right, bst_array);
        
    }
};

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Your code here along with comments explaining your approach
//Approach without an extra space
//1. Do inorder traversal
//2. Search for inconsistency and set two pointers to the appropriate values.
//3. If found at only one place swap the two immediate numbers.
//4. Else swap the first pointer and last pointer of second dicrepancy.

class Solution {
public:
    bool flag_first_swap = false;
    TreeNode* prev=NULL;
    TreeNode* first= new TreeNode(); TreeNode* second = new TreeNode();
    
    void recoverTree(TreeNode* root) {
        //edge
        if(root == NULL) return;
        
        //inorder traversal
        inorder(root);
        
        int temp = first->val;
        first->val = second->val;
        second->val =temp;
        
    }
    
    void  inorder(TreeNode* root){
        //returning condition
        if(root==NULL) return;
        
        //traverse through nodes
        inorder(root->left);
        if (prev !=NULL && flag_first_swap == false && prev->val >= root->val){
            first = prev;
            second = root;
            flag_first_swap=true;
        }else if(prev !=NULL  && flag_first_swap == true && prev->val>=root->val){
            second = root;
        }
        prev= root;
        inorder(root->right);
    }
};
