// Time Complexity - O(n) where n is the number of nodes in the tree
// Space Complexity - O(1)
// This solution worked on LeetCode

class Solution {
    public Node connect(Node root) {
        Node temp = root;     // temp will be pointing at the start of each level
        while(temp != null){
            Node curr = temp;   // curr will be traversing the nodes in each level
            while(curr != null){
                if(curr.right != null && curr.next != null){
                    curr.right.next = curr.next.left;    // next pointer from right child of one parent to left child of other parent
                }
                if(curr.left != null){
                    curr.left.next = curr.right;    // next pointer from left child to right child node
                }
                curr = curr.next;     // move the curr to next
            }
            temp = temp.left;         // move the temp to start of next level
        }
        return root;
    }
}
