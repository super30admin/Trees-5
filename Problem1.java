//https://leetcode.com/problems/populating-next-right-pointers-in-each-node/

// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

/*
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
};
*/

// class Solution {
//     public Node connect(Node root) {
//         if(root==null) return null;
//        Queue<Node> q = new LinkedList<>();
//        q.add(root);
//        while(!q.isEmpty()){
//         int ls=q.size();
//         Node prev=null;
//         for(int i=0;i<ls;i++){
//             if(i==0) prev=q.poll();
//             else {
//                 Node temp = q.poll();
//                 prev.next=temp;
//                 prev=temp;
//             }
//             if (prev.left!=null){q.add(prev.left); q.add(prev.right);}
//         }
//        }
//        return root;
//     }
// }


class Solution {
    public Node connect(Node root) {
        if(root==null) return root;
        Node level = root;
        while(level.left!=null){
            Node current = level;
            while(current!=null){
                current.left.next=current.right;
                if(current.next!=null) current.right.next=current.next.left;
                current= current.next;
            }
            level=level.left;
        }
        return root;
    }
}