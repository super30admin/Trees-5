//https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
/*
Time: O(n) where n=number of nodes
Space: O(1) 
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None
*/
public class NextRightPointers {

    public Node connect(Node root) {

        if (root == null || root.left == null || root.right == null)
            return root;

        root.left.next = root.right; // 2->3

        if (root.next != null)
            root.right.next = root.next.left; // 5->6

        connect(root.left);
        connect(root.right);

        return root;

    }
}
