// Time Complexity: O(n)
// Space Complexity: O(h) where h is height of the tree
// iterative
public class RecoverBst {
    public void recoverTree(TreeNode root) {
        if(root == null)
            return;
        TreeNode prev = null, first = null, second = null;
        Stack<TreeNode> s = new Stack<>();
        // inorder traversal gives sorted order
        while(root != null || !s.isEmpty())
        {
            // inorder keep going left
            while(root != null)
            {
                s.push(root);
                root = root.left;
            }
            
            // get root
            root = s.pop();
            
            // get root and add mistmatch logic
            if(prev != null && prev.val >= root.val)
            {
                if(first == null) // only if we have not found first mismatch
                {
                    first = prev;
                    second = root;
                }
                else
                {
                    second = root;
                    break; // optimization to break the checks since question gaurantees that there will be only 2 mismatch
                }
            }
            
            // before going to right init prev
            prev = root;
            
            // go right
            root = root.right;
        }
       
        // swap the mismatched vals
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
}

// Time Complexity: O(n)
// Space Complexity: O(h) where h is height of the tree
// recursive
public class RecoverBst {
    TreeNode prev, first, second;
    public void recoverTree(TreeNode root) {
        if(root == null)
            return;
        
        inorder(root); // inorder traversal gives sorted order
        
        // swap the mismatched vals
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
    
    
    private void inorder(TreeNode root)
    {
        // base
        if(root == null)
            return;
        
        // logic
        // inorder keep going left
        inorder(root.left);
        
        // get root and add mistmatch logic
        if(prev != null && prev.val >= root.val)
        {
            if(first == null) // only if we have not found first mismatch
            {
                first = prev;
                second = root;
            }
            else
            {
                second = root;
                return; // optimization to break the checks since question gaurantees that there will be only 2 mismatch
            }
        }
        
        // before going to right init prev
        prev = root;
        inorder(root.right);
    }
}