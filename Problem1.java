//Time Complexity: O(n)
//Space Complexity:O(1)

class Solution {

    public Node connect(Node root) {
        if(root == null) return null;
        Node level = root;
        while(level.left!=null){
            Node current = level;
            while(current!=null){
                current.left.next = current.right;
                if(current.next != null){
                    current.right.next = current.next.left;
                }
                current = current.next;
            }
            level = level.left;  
        }
        return root;
    }
}
