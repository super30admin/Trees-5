// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach


 // We will traverse through the tree in an inorder manner. Whenever we come across a breach , where the left node is greater than the root, 
 // or the right node is smaller than the root, then we store the value of that node in a variable. The we search for the second breach and 
 // when we find it we swap the two nodes.
 class Solution {
    TreeNode first, second, prev;

    public void recoverTree(TreeNode root) 
    {
        inorder(root);
        int temp=first.val;
        first.val=second.val;
        second.val=temp;
    }

    private void inorder(TreeNode root)
    {
        //base
        if(root==null) return;

        //logic
        inorder(root.left);
        //breach
        if(prev!=null && prev.val>root.val)
        {
            //if the first breach is not found yet
            if(first==null)
            {
                first=prev; //set first to the prev value which is greater than the root
                second=root;    //set second to root, which is the smaller one
            }
            //if first breach is found,then we look for the second one
            else
            {
                second=root;
            }
        }
        prev=root;
        inorder(root.right);
    }

}


//Iterative method
class Solution {
    TreeNode first, second, prev;

    public void recoverTree(TreeNode root) 
    {
        inorder(root);
        int temp=first.val;
        first.val=second.val;
        second.val=temp;
    }

    private void inorder(TreeNode root)
    {
        //logic
         Stack<TreeNode> st= new Stack<>();
        while(!st.isEmpty() || root!=null)
        {
            while(root!=null)
            {
                st.push(root);
                root=root.left;
            }
            root=st.pop();
        //breach
        if(prev!=null && prev.val>root.val)
        {
            //if the first breach is not found yet
            if(first==null)
            {
                first=prev; //set first to the prev value which is greater than the root
                second=root;    //set second to root, which is the smaller one
            }
            //if first breach is found,then we look for the second one
            else
            {
                second=root;
            }
        }
    
        prev=root;
        root=root.right;
        
        }
    }
}