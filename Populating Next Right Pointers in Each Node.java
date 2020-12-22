//TIme complexity:O(n)
//Space complexity:O(h)

class Solution {
    //Level pointer
    public Node connect(Node root) {
        if(root==null) return null;
         helper(root);
        return root;
    }
    private void helper(Node root)
    {
        //base
        if(root==null) return ;
        //action
        if(root.left!=null)
        {
            root.left.next=root.right;
        }
        if(root.left!=null &&root.next!=null)
        {
            root.right.next=root.next.left;
        }
        //logic
        helper(root.left);
        helper(root.right);
    }
}
