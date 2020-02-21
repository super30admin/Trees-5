// TC - O(n)
// SC - O(h)

//Effectively BFS
class Solution {
    public Node connect(Node root) {
        
        if(root == null) return root;
        
        root.next = null;
        addPointers(root);
        
        return root;
    }
    
    private void addPointers(Node node)
    {
        //base
        if(node.left == null && node.right == null) return;
        
        //logic
        if(node.left != null)
        {
            node.left.next = node.right;
            addPointers(node.left);
        }
        if(node.right != null)
        {
            if(node.next != null)
                node.right.next = node.next.left;
            else
                node.right.next = null;
            
            addPointers(node.right);
        }
    }
}
