//Time Complexity : O(n)
//Space Complexity : O(h)


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    //Recursive Approach
    
    TreeNode first, second, prev;
    
    public void recoverTree(TreeNode root) {
        
        if(root == null) return;
        
        inorder(root);
        
        int temp = first.val;
        first.val = second.val;
        second.val = temp; 
    }
    
    private void inorder(TreeNode node){
        
        if(node == null) return;

        inorder(node.left);
        
        if(prev!= null && prev.val >= node.val){
            //breach
            second = node;
            if(first == null){
                first = prev;
            }
        }
        prev = node;
        
        inorder(node.right); 
    }
    
    
    
    //Iterative Approach
    
    
//     public void recoverTree(TreeNode root) {
     
//         TreeNode prev = null;
//         TreeNode first = null;
//         TreeNode second = null;
//         Stack<TreeNode> stack = new Stack<>();
        
//         while(root!= null || !stack.isEmpty()){
            
//             while(root!= null){
//                 stack.push(root);
//                 root = root.left;
//             }
            
//             root = stack.pop();
            
//             if(prev != null && prev.val >= root.val){
                
//                 second = root;
//                 if(first == null){
//                     first = prev;
//                 }   
//             }
//             prev = root;
//             root = root.right;
//         }
        
//         int temp = first.val;
//         first.val = second.val;
//         second.val = temp;
//     } 
}
