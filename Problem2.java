// Time Complexity - O(n) where n is the number of nodes in the tree
// Space Complexity - O(1)
// This solution worked on LeetCode

class Solution {
    TreeNode first,middle,last,prev;
    public void recoverTree(TreeNode root) {
        inorder(root); 
        int temp;
            if(first != null && last != null){ // Case 1 when prev and root are not adjacent, swap the first and last
                temp = first.val;
                first.val = last.val;
                last.val = temp;
            }
            else if(first != null && middle != null){   // Case 2 when prev and root are adjacent, swap the first and middle
                temp = first.val;
                first.val = middle.val;
                middle.val = temp;   
            }    
    }
    private void inorder(TreeNode root){
        if(root == null)    return;
        inorder(root.left); // recursively call the function for root.left
        if(prev != null && prev.val > root.val){    // prev > root populate prev and middle which is the first occurence of the mistake
            if(first == null && middle == null){
                first = prev;
                middle = root;
            }
            else{       // else it is the second occurence of mistake if first is not null, so last will be equal to the second mistake
                last = root;
            }    
        }     
        prev = root;  // make the prev to root and recursively call the function for root.right
        inorder(root.right);
    }
}
