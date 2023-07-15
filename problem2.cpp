/*
// Time Complexity : O(N)
// Space Complexity : O(H)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
Do inorder traversal find the two nodes that are to be swapped and then swap.
*/

#include<iostream>
#include<vector>
#include<stack>

using namespace std;

typedef struct TreeNode{
    int val;
    TreeNode* left;
    TreeNode* right;
    TreeNode(): val(0),left(nullptr),right(nullptr){}
    TreeNode(int _val): val(_val),left(nullptr),right(nullptr){}
    TreeNode(int _val,TreeNode* _left,TreeNode* _right): val(_val),left(_left),right(_right){}
}TreeNode;

// first recurrsive Traversal of the tree

class Solution {
    TreeNode* first{NULL};
    TreeNode* second{NULL};
    TreeNode* curr{NULL};
    TreeNode* prev{NULL};
    void dfs(TreeNode* node){
        //base
        if(node == NULL){
            return;
        }
        //logic
        dfs(node->left);
        prev = curr;
        curr = node;
        
        if(prev && prev->val>curr->val){
            //cout<<"prev->val "<<prev->val<<" curr->val "<<curr->val<<endl; 
            if(first == NULL){
                first = prev;
                second = node;
            }
            else{
                second = node;
                return;
            }
        }
        dfs(node->right);
    }
public:
    void recoverTree(TreeNode* root) {
        //cout<<"prev curr"<<endl;
        dfs(root);
        int temp = first->val;
        first->val = second->val;
        second->val = temp; 
    }
};

// second iterative traversal of the tree


class Solution {
public:
    void recoverTree(TreeNode* root) {
        TreeNode* curr{NULL};
        TreeNode* prev{NULL};
        TreeNode* first{NULL};
        TreeNode* second{NULL};
        
        stack<TreeNode*> st;
        //loop based recursion

        TreeNode* node{root};

        while(node!=NULL || !st.empty()){
            while(node!=NULL){
                st.push(node);
                node = node->left;
            }
            node = st.top();
            st.pop();
            prev = curr;
            curr = node;
            //cout<<"curr->val "<<curr->val<<endl;

            if(prev && prev->val>curr->val){
                if(first == NULL){
                    first = prev;
                    second = curr;
                    //cout<<first->val<<" "<<second->val<<endl;
                }
                else{
                    second = node;
                    //cout<<second->val;
                    break;
                }
            }
            node = node->right;
        }
        int temp = first->val;
        first->val = second->val;
        second->val = temp;
    }
};

