


/**
 * Connects each node's next pointer to its right neighbor in a perfect binary tree.
 * Traverses level by level using already established next pointers.
 * Returns the modified tree with populated next pointers.
 */
// Time Complexity: O(N), where N is the number of nodes in the tree
// Space Complexity: O(1), since no extra space is used apart from pointers
public class PopulatingNextRightPointer {

    public Node connect(Node root) {
        if(root == null) return null; 

        Node leftMost = root; 

        while(leftMost.left != null) {
            Node curretNode = leftMost; 
            while(curretNode != null) {
                curretNode.left.next = curretNode.right; 
                if(curretNode.next != null) {
                    curretNode.right.next = curretNode.next.left;
                }
                curretNode = curretNode.next;
            }
        leftMost = leftMost.left;
    }
    return root;
}
    
}
