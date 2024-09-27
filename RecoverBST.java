/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/*Algorithm: 
    1. Do an inOrder traversal.
    2. If the prev value is greater than the root val and prev is not null then set first to prev and middle to root. Else set prev to root
    3. If first and last are not empty, interchange them, else if first and middle are not empty interchange them.
    
    Time Complexity: O(n)
    Space Complexity: O(1)
*/
    

class Solution {
    
    TreeNode first, middle, last, prev;
    public void recoverTree(TreeNode root) {
        inOrder(root);
        int temp;
        if(first!=null && last!=null){
            temp = last.val;
            last.val = first.val;
            first.val = temp;
        }
        else if(first!=null && middle!=null){
            temp = middle.val;
            middle.val = first.val;
            first.val = temp;
        }
        
    }
    
    private void inOrder(TreeNode root){
        //Base Case
        if(root==null)
            return;
        inOrder(root.left);
        
        if(prev!=null && prev.val>root.val){
            
        if(first==null){
              first = prev;   // 3
            //System.out.println("First"+first.val);


             middle = root;  
           // System.out.println("Middle"+middle.val);
        }
        else{
            last = root; // 2
           // System.out.println("Last"+last.val);
        }
    }
        
        prev = root; // prev=2
        //System.out.println("Prev"+prev.val);
        
        inOrder(root.right);
    }
}