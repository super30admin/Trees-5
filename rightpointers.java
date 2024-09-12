//Time Complexity:O(N) where N is the number of nodes in the tree
//SPace Complexity:O(1)
//Approach- If root is not null, check if the left element is not null, then mark the next element of left to be its right element. SImilarly, if the next element to the current is not null, then mark the next element of cureent right to be the left element of the next element.
//This code was executed successfully and got accepted in leetcode.

class Solution {
    public Node connect(Node root) {
        Node level=root;
        while(level!=null){
            Node cur=level;
            while(cur!=null){
                if(cur.left!=null){
                    cur.left.next=cur.right;
                }
                    
                if(cur.right!=null&&cur.next!=null){
                    cur.right.next=cur.next.left;
                }
                    
                cur=cur.next;
            }
            level=level.left;
        }
        return root;
    }
}