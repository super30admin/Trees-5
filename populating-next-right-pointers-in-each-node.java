// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

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
// Iterative Program
// class Solution {
//     public Node connect(Node root) {
//         if(root == null)
//             return root;
        
//         Node firstLevelNode = root;
        
//         while(firstLevelNode.left != null) {
//             Node cursor=firstLevelNode;
            
//             while(cursor != null)
//             {
//                 cursor.left.next=cursor.right;
//                 if(cursor.next != null)
//                     cursor.right.next=cursor.next.left;
            
//                 cursor=cursor.next;
//             }
//             firstLevelNode=firstLevelNode.left;
//         }
//         return root;
//     }
// }

// Recursive Program
class Solution {
    public Node connect(Node root) {
        if (root == null)
            return root;
        
        if(root.left != null) {
            root.left.next=root.right;
            if(root.next != null)
                root.right.next=root.next.left;
        }
        connect(root.left);
        connect(root.right);
        
        return root;
    }
}
