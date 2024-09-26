// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach : Recursive Solution
/*
 * 1 - We are following the logic of Validate BST where two pointers are maintained - prev and root. We record the 
 * breaches(one breach for adjacent nodes in same subtree; 2 breaches for different subtree).
 * 2 - Remember, we have to store the second breach in the second pointer since first and second can be swapped.
 * 3 - the first breach assigns both the first and second vars but the second pointer is reassigned
 */

public class RecoverBST {
    TreeNode first;
    TreeNode second;
    
    TreeNode prev;
    public void recoverTree(TreeNode root) {
        if(root == null)
            return;
        
        inorder(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
    
    public void inorder(TreeNode root)
    {
        //base
        if(root == null)
        {
            return;
        }
        //logic
        inorder(root.left);
        
        if(prev != null && prev.val >= root.val)
        {
            if(first == null)
            {
                first = prev;
                second = root;
            }
            else
            {
                second = root;
            }
        }
        
        prev = root;
        inorder(root.right);
    }
}

// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach : Recursive Solution
/*
 * Approach 2 - Iterative Stack Solution
 */
TreeNode first;
TreeNode second;

public void recoverTree(TreeNode root) {
    if(root == null)
        return;
    
    inorder(root);
    int temp = first.val;
    first.val = second.val;
    second.val = temp;
}

public void inorder(TreeNode root)
{
    Stack<TreeNode> st = new Stack<>();
    TreeNode prev = null;
    
    while(root != null || !st.isEmpty())
    {
        while(root != null)
        {
            st.push(root);
            root = root.left;
        }
        root = st.pop();
        if(prev != null && prev.val >= root.val)
        {
            if(first == null)
            {
                first = prev;
                second = root;
            }
            else
            {
                second = root;
            }
        }
        prev = root;
        root = root.right;
    }
}