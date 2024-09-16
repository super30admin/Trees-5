// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

/**
 * Populate the links level by level ony travelling left of the current node and joining them towards right
 */


public class populatingRightNxtPtrs {
    public Node connect(Node root) {
        if(root == null) return null;
        
        Node currLevel = root;
        
        while(currLevel.left != null) {
                Node node = currLevel;

                while(node != null){
                node.left.next = node.right;

                if(node.next != null) {
                    node.right.next = node.next.left;
                }

                node = node.next;

            }
            currLevel = currLevel.left;
        }
        return root;
    }
}
