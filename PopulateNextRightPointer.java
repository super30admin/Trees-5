// Time Complexity : O(V+E)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//at each level, process its children to add links between them.
//keep track of level and also node at each level with curr pointer 

class Solution {
    public Node connect(Node root) {
        if(root==null) return null;
        Node curr=root;
        Node level=root;
        
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