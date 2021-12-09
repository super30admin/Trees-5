//116. Populating Next Right Pointers in Each Node
// time - O(h)
// space - O(n)
class Solution {
    public Node connect(Node root) {
        
        if(root == null){
            return null;
        }
        
        if(root.left != null){
            root.left.next = root.right;
        }
        
        if(root.right != null && root.next != null){
            root.right.next = root.next.left;
        }
        
        connect(root.left);
        connect(root.right);
        
        return root;
    }
}