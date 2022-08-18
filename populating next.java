// Time Complexity : o(n)
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no




// Your code here along with comments explaining your approach

class Solution {
    public Node connect(Node root) {
        if(root==null) return root;
        Node level=root;
        Node curr = null; 
        while(level.left!=null){
            curr=level;
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