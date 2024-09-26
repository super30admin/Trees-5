// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Dificult to think the optimal approach

// Your code here along with comments explaining your approach

class Solution {
    public Node connect(Node root) {
        if(root == null)
            return null;
        
        Node level = root; //to keep track of level and increment to next level
        Node curr = root; //to traverse within the level
        while(level.left != null) {
            curr = level;
            while(curr != null){
                curr.left.next = curr.right; //connecting same parent's child
                if(curr.next != null){
                    curr.right.next = curr.next.left; //connecting next parent's child
                }
                curr = curr.next; //increment curr
            }
            level = level.left; //increment level
        }
        return root;
    }
}

//(As it is complete binary tree we don't need to worry about missing left child)