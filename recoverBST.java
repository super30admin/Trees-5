// Time Complexity : O(N)
// Space Complexity : O(H), height of tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : After class solution


// Your code here along with comments explaining your approach

//iterate
class Solution {
    public void recoverTree(TreeNode root) {
        //do an inorder traversal
        //store in an array
        //check if previous element is >er than current element, if yes then put the previous as first element to be swapped
        //check if first element is detected and again previous element is >er than current. If yes, then put the current as second element to be swapped
        //remember to point back the previous to current
        //swap both the elements
        
        Stack<TreeNode> s = new Stack<>();
        TreeNode curr = root;
        TreeNode prev = new TreeNode(Integer.MIN_VALUE);
        TreeNode first = null, second = null;
        
        while(curr != null || !s.isEmpty()){
            while(curr != null){
                s.push(curr);
                curr = curr.left;
            }
            
            curr = s.pop();
            if(prev.val > curr.val && first == null){
                first = prev;
            }
            if(prev.val > curr.val && first != null){
                second = curr;
            }
            prev = curr;
            curr = curr.right;
            
        }
        
        swap(first,second);
        return;
    }
    
    private void swap(TreeNode a, TreeNode b){
        int temp = a.val;
        a.val = b.val;
        b.val = temp;
    }
}

//***********************************
//recursive version with global variables. Please learn using wrapper.

class Solution {
    
    TreeNode prev = new TreeNode(Integer.MIN_VALUE);
    TreeNode first = null, second = null;
    
    public void recoverTree(TreeNode root) {
       //recursive version
        
        inOrderTraverse(root);
        swap(first, second);
    }
    
    private void inOrderTraverse(TreeNode node){
        
        if(node == null) return;
        
        inOrderTraverse(node.left);
        
        if(first == null && prev.val > node.val)
            first = prev;
        
        if(first != null && prev.val > node.val)
            second = node;
        
        prev = node;
        
        inOrderTraverse(node.right);
        
    }
    
    private void swap(TreeNode a, TreeNode b){
        int temp = a.val;
        a.val = b.val;
        b.val = temp;
    }
}