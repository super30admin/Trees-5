// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// keep traversing to next node and keep updating next pointer of both children. Take care of edge case of last node of a level

class Solution {
    public Node connect(Node root) {
        if(root == null) return null;
        Node pre = root;
        while(pre.left != null){
            Node temp = pre;
            while(temp != null){
                temp.left.next = temp.right;
                if(temp.next != null) temp.right.next = temp.next.left;
                temp = temp.next;
            }
            pre = pre.left;
        }
        return root;
    }
}