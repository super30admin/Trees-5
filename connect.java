//time complexity-O(n)
//space complexity-O(1)
//Ran on leetcode-Yes
//Solution with comments-

class Solution {
    public Node connect(Node root) {
        Node top=root;//top variable to maintain the level
        while(top!=null){
            Node curr= top;//to traverse current level
            while(curr!=null){
                if(curr.left!=null)
                    curr.left.next=curr.right;
                if(curr.next!=null && curr.right!=null)
                    curr.right.next=curr.next.left;
                curr=curr.next;
            }
            top=top.left;
        }
        return root;
    }
}