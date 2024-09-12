// Time Complexity : O(N) where N is the number of nodes
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Traverse level by level and set the pointers
public class PopulateNextRightPtr {
    public Node connect(Node root) {
        if(root==null) return root;

        Node level=root;
        while(level.left!=null){
            Node curr=level;
            while(curr!=null){
                curr.left.next=curr.right;
                if(curr.next!=null){
                    curr.right.next=curr.next.left;
                }
                curr=curr.next;
            }
            level=level.left;
        }

        return root;
    }
}
