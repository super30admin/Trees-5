
//Time: O(N)
//Space: O(h)

//Approach: write out the inorder traversal
//Brute force: sort the order, construct the tree, return root
//Optimized: Two pointers: find 2 breaches of bst properties
//prev and root
//whenever prev > root then there is a breach
//store breach in 2 vars: first and last
//when u find second breach replace last value with lower value
//there might be only single breach, keep a flag
//flag = true after first breach, false after second breach
//if flag true by the end of iteration then just switch first and last vars


class Solution {
    TreeNode prev;
    boolean flag;
    TreeNode first, last;
    public void recoverTree(TreeNode root) {
        if(root == null)
            return;
        
        inorder(root);
        int temp = first.val;
        first.val = last.val;
        last.val = temp;
    }
    
    private void inorder(TreeNode root){
        //base
        if(root == null) return;
        //logic
        inorder(root.left);
        //root
        if(prev != null && prev.val > root.val){
            
            //first breach
            if(!flag){
                first = prev;
                last = root;
                flag = true;
            }
            //second breach
            else{
                last = root;
                
            }
        }
        prev = root;
        inorder(root.right);
    }
}