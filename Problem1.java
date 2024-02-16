// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class Solution {
    public Node connect(Node root) {
        if(root == null)
            return null;
        Node level = root;
        while(level.left!=null){
            Node curr = level;
            while(curr!=null){
            
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