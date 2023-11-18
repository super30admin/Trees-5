// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : none


// Your code here along with comments explaining your approach

class ConnectNextPointer {
    
    public Node connect(Node root) {
       Node level = root;
        while(level!=null && level.left!=null){
            Node curr = level;
            while(curr != null){
                curr.left.next = curr.right;
                if(curr.next!=null){
                    curr.right.next = curr.next.left;
                }
                curr = curr.next;
            }
            level = level.left;
        }
        return root;
    }
}