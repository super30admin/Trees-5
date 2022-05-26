
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

// 1) when traversing tree 
// 2) We will keep variables, first, second, prev
// 3) Inorder traversal
//     a. Once u reach base case (curr is null), prev will become last non null node
//     b. We check prev with parent, if it is less, then that node becomes prev and we check with right.
//     c. If we find prev is greater than last element, then record prev in first
//     d. But for second element, we will record second to root when we find the first
//         i. Reason we do this what if two wrong places element are parent child, then our below logic will not capture the second
//     e. Then we keep traversing, if we find one more element wrong, override root in second
//     f. Then swap first and second

//iterative version
public void RecoverTree(TreeNode root) {
    if(root == null)
        return;
    
    //recursive approach
    //inorder(root);
    
    Stack<TreeNode> stack = new Stack<TreeNode>();        
    
    while(root != null || stack.Count > 0)
    {
        while(root != null)
        {
            stack.Push(root);
            root = root.left;
        }
        
        root = stack.Pop();
        
        if(prev != null && prev.val >= root.val)
        {
            if(first == null)
                first = prev;
            second = root;
        }
        prev = root;
        root = root.right;
    }
    
    int temp = first.val;
    first.val = second.val;
    second.val = temp;
}

//recursive approach
TreeNode prev, first, second;
public void RecoverTree(TreeNode root) {
    if(root == null)
        return;
    
    
    inorder(root);

    int temp = first.val;
    first.val = second.val;
    second.val = temp;
}

private void inorder(TreeNode root)
{
    //base
    if(root == null)
        return;
    
    //logic
    inorder(root.left);
    
    if(prev != null && prev.val >= root.val)
    {
        if(first == null)
        {
            first = prev;                
        }
        second = root;
    }
    prev = root;
    inorder(root.right);
}