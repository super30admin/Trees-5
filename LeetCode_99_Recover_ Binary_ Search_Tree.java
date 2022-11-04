//Note - In Binary search tree so everything right to Root is greater than root and left side will be less than Root. 
//approach -1\
//traverse - in-order  - store values in list - sort - swapped nodes will be updated. 
//also, we dont have to change the structure, which says only swap values not right or left reference etc. 
//TC - O(N) traversal + O(N log N) sorting, SC - O(H)recursive stack + O(N) List


//approach -2
//traverse - inorder way - why inorder ? because it gives us sorted array!
//store it in list
//traverse through list and store first mismatch and second mismatch - (i+1 value must be greater than i!)
//once done trversing, just swap this values back 
//TC - O(N) tree traversal + O(N) list traversal + swap O(1)
//sc - O(H)recursive stack + O(N) List

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
    TreeNode prev, first, second;
    public void recoverTree(TreeNode root) {
        if(root == null) return;
        
        inorder(root);
       
        //swapping
        int temp = first.val;
        first.val = second.val;
        second.val =temp;
        
    }
    
    private void inorder(TreeNode root)
    {
        if(root == null) return;
        
        //logic
        inorder(root.left);
       //process the nodes here!
        
        if(prev != null && prev.val >= root.val) //first time prev is null so null check and also in future left child/ prev can be empty
        {
            if(first == null)
            {
                first = prev;
            }
            second = root;
        }
        prev = root; //update the prev - increment in one sense!
        inorder(root.right);
     
    }
}


//Iterative approach
//tc -O(N)
//SC -O(h)

//Note - In Binary search tree so everything right to Root is greater than root and left side will be less than Root. 
//approach -1\
//traverse - in-order  - store values in list - sort - swapped nodes will be updated. 
//also, we dont have to change the structure, which says only swap values not right or left reference etc. 
//TC - O(N) traversal + O(N log N) sorting, SC - O(H)recursive stack + O(N) List


//approach -2
//traverse - inorder way - why inorder ? because it gives us sorted array!
//store it in list
//traverse through list and store first mismatch and second mismatch - (i+1 value must be greater than i!)
//once done trversing, just swap this values back 
//TC - O(N) tree traversal + O(N) list traversal + swap O(1)
//sc - O(H)recursive stack + O(N) List

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
    TreeNode prev, first, second;
    public void recoverTree(TreeNode root) {
        if(root == null) return;
        
        Stack<TreeNode> s = new Stack<>();
        
        while(root != null || !s.isEmpty())
        {
            while(root != null)
            {
                s.push(root);
                root = root.left;
            }
            root = s.pop();
            //process the root
            if(prev != null && prev.val >= root.val) //first time prev is null so null check and also in future left child/ prev can be empty
            {
                if(first == null)
                    first = prev;
                
                second = root;
            }
            prev = root;
            root = root.right;
         }
      
        //swapping
        int temp = first.val;
        first.val = second.val;
        second.val =temp;
        
    }
    
    }