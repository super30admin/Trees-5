/*
Time Complexity: O(N), number of nodes in the tree
Space Complexity: O(1), This solution is iterative so constant space
Run on Leetcode: yes
Any difficulties: no

Approach:
1. Attempted after discussed in the class
 */
public class PopulatingNextRightPointersInEachNode {
    public static class Node{
        int val;
        Node left;
        Node right;
        Node next;

        Node(){
        }

        Node(int val){
            this.val = val;
        }
        Node(int val, Node left, Node right, Node next){
            this.val = val;
            this.left = left;
            this.right = right;
            this.next = next;
        }
    }

    public static Node connect(Node root){
        if(root == null){
            return root;
        }

        Node leftMost = root;

        while(leftMost.left!= null){
            Node head = leftMost;

            while(head!= null){
                head.left.next = head.right;

                if(head.next!= null){
                    head.right.next = head.next.left;
                }
                head = head.next;
            }
            leftMost = leftMost.left;
        }
        return root;
    }
}
