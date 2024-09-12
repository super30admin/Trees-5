// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : getting started


// Your code here along with comments explaining your approach

public class PopulatingNextRightPointersInEachNode {

    // Definition for a Node.
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }


    class Solution {
        public Node connect(Node root) {
            if(root == null) return root;//base case

            Node leftNode = root;// node to move down the left side
            while(leftNode.left != null){//traverse down over left side and then point it to the next node on right
                Node head = leftNode;
                while(head != null){
                    head.left.next = head.right;
                    if(head.next != null){
                        head.right.next = head.next.left;
                    }
                    head = head.next;
                }
                leftNode = leftNode.left;
            }
            return root;
        }
    }

}
