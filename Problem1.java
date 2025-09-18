
//Time Complexity: O(N)
//Space Complexity: O(1)

// we are using the already established next pointers to traverse the tree level by level
// we connect the left child to the right child and the right child to the next node's left child if it exists
// we move down the tree level by level until we reach the leaves
// this approach works because the tree is a perfect binary tree

class Solution {
    public Node connect(Node root) {
        if(root==null) return null;

        Node level=root;
        while(level.left!=null){
            Node curr=level;
            while(curr!=null){
                curr.left.next=curr.right;
                if(curr.next!=null)
                    curr.right.next=curr.next.left;
                curr=curr.next;
            }
            level=level.left;
        }
        return root;
    }
}