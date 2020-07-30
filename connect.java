// Time Complexity : O(n) n is number of nodes
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public Node connect(Node root) {
        if(root==null) return root;
        
        Node curr = root;
        
        while(curr.left!=null){
            Node temp = curr;
            while(temp!=null){
                temp.left.next = temp.right;
                if(temp.next!=null){
                    temp.right.next = temp.next.left;
            }
                temp = temp.next;
            }
            curr = curr.left;
        }
        return root;
    }
}