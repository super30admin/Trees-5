// Recover Binary Search Tree
// TC : O(n)
// SC : O(h)
// Ran on LC : Yes
// Problems faced : No

class Solution {
    TreeNode first;
    TreeNode second;
    
public void recoverTree(TreeNode root) {
    
    if(root == null) return;
    inorder(root);
    int temp = first.val;
    first.val = second.val;
    second.val = temp;
}

    public void inorder(TreeNode root){
    
    TreeNode prev = null;
    Stack<TreeNode> st = new Stack<>();
    while(root!=null || !st.isEmpty())
    {
        while(root!=null){
        st.push(root);
        root = root.left;
    }
    root = st.pop();
    if(prev != null && prev.val >= root.val){
        if(first == null){
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

// Populating Next Right Pointers in Each Node
// TC : O(n)
// SC : O(1)
// Ran on LC : Yes
// Problems faced : No

class Solution {
    public Node connect(Node root) {
        if(root == null) return root;
        Node level = root;
        while(level.left != null)
        {
            Node curr = level;
            while(curr!= null)
            {
            curr.left.next = curr.right;
            if(curr.next != null)
            {
            curr.right.next = curr.next.left;
            }
                curr = curr.next;
        }
        level = level.left;
    }
        return root;
    }
}