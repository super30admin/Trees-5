// Time Complexity : O(n)
// Space Complexity :O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution 
{
    TreeNode first;
    TreeNode second;
    
    public void recoverTree(TreeNode root) 
    {
        if(root == null)
        {
            return;
        }
        
        inorder(root);
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }
    
    private void inorder(TreeNode root)
    {
        TreeNode prev = null;
        Stack<TreeNode> st = new Stack<>();
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
}

// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution 
{
    public Node connect(Node root) 
    {
        if(root == null)
        {
            return root;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            int size = q.size();
            Node prev = null;
            for(int i = 0; i < size; i++)
            {
                Node curr = q.poll();
                if(i != 0)
                {
                    prev.next = curr;        
                }
                if(curr.left != null)
                {
                    q.add(curr.left);
                    q.add(curr.right);
                }
                prev = curr;
            }
        }
        return root;
    }
}