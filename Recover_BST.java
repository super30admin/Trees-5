//BruteForce Appraoch
//inorder traversal, save it in an array and check for missed sorted sequence
//Time: O(n) -> inorderbtraversal & swap -> O(1) ==> so, overall O(n)
//Space: O(n)

/* Iterative solution
On the Fly Inoder traversal and then check if prev > current
Time: O(n)
Space: O(h) -> height of the tree
KeyNote: check if two adjuscent nodes are swap by each other how to track that condition

class Solution {
    
    TreeNode first;
    TreeNode second;
    TreeNode prev;
    
    public void recoverTree(TreeNode root) {
        
        if(root == null)
            return;
        
        first = null;
        second = null;
        prev = new TreeNode(Integer.MIN_VALUE);
        
        Stack<TreeNode> stk = new Stack<>();
        
        TreeNode current = null;
        
        //following inorder traversal here, so pushing all left elements in the stack
        while(root != null)
        {
           stk.push(root);
           root = root.left;
        }
        
        while(!stk.isEmpty())
        {
            current = stk.pop();
            if(first == null && prev.val > current.val)
                first = prev;

            //second condition
            if(first !=null && prev.val > current.val)
                second = current;
            
            prev = current;
            
            if(current.right !=null)
            {
               current = current.right;
               while(current != null)
               {
                    stk.push(current);
                    current = current.left;
               }
                   
            }     
        }
        
        swap(first, second);    
    }
    
    
    private void swap(TreeNode a, TreeNode b)
    {
        int temp = a.val;
        a.val = b.val;
        b.val = temp;
    }
} */



/** Recursive Solution 
Time: O(n)
Space: O(h)
*/
class Solution {
    
    TreeNode first;
    TreeNode second;
    TreeNode prev;
    
    public void recoverTree(TreeNode root) {

        if(root == null)
            return;
        
        first = null;
        second = null;
        prev = new TreeNode(Integer.MIN_VALUE);
        
        inOrder(root);
    
        swap(first, second);    
    }
    
    private void inOrder(TreeNode root)
    {
        if(root == null)
            return;
        inOrder(root.left);
        if(first == null && prev.val > root.val)
                first = prev;
        if(first !=null && prev.val > root.val)
                second = root;
        prev = root;
        inOrder(root.right);
    }
    
    private void swap(TreeNode a, TreeNode b)
    {
        int temp = a.val;
        a.val = b.val;
        b.val = temp;
    }
}
