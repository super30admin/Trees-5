/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
    
          1
    2           3
4       5   6       7

Queue - 4 5 6 7

1 -> null
2 -> 3 -> null
4 -> 5 -> 6 -> 7 -> null

DFS traversal of a tree.
preorder - NLR
-> postorder - LRN 
inorder - LNR

};

TC - O(N) where N is the number of nodes 
SC - O(H) where H is the height of the tree.
*/

class Solution {
    
    public Node connect(Node root) {
        
        if (root == null)
        {
            return null;
        }
        
        connectHelper(root);
        return root;
    }
    
    private void connectHelper(Node root)
    {
        //base case
        if (isLeaf(root))
        {
            return;
        }
        
        // process root
        root.left.next = root.right;
        
        if (root.next != null)
        {
            root.right.next = root.next.left;
        }
        
        // recur left
        connectHelper(root.left);
        
        // recur right 
        connectHelper(root.right);
    }
    
    private boolean isLeaf(Node root)
    {
        return root.left == null && root.right == null;
    }
}
