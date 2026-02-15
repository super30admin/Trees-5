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
// Solution - Iterative Solution using a Queue : Level Order
// TC - O(n)
// SC - O(n)
// class Solution {
//     public Node connect(Node root) {
//         if(root == null) return root;
//         Queue<Node> q = new LinkedList<>();
//         q.add(root);

//         while(!q.isEmpty()) {
//             int size = q.size();
//             System.out.println(size);
//             while(size>0) {
//                 Node node = q.poll();
//                 size--;

//                 if(size >0) {
//                     node.next = q.peek();
//                 }

//                 if(node.left != null) {
//                     q.add(node.left);
//                 }
//                 if(node.right != null) {
//                     q.add(node.right);
//                 } 

//             }

//         }
//         return root;

//     }
// }

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

// Solution - Iterative Approach. 
// TC - O(n)
// SC - O(1)
class Solution {
    public Node connect(Node root) {
        if (root == null)
            return root;
        Node level = root;
        while (level.left != null) {

            Node node = level;
            while (node != null) {
                node.left.next = node.right;
                if (node.next != null) {
                    node.right.next = node.next.left;
                }
                node = node.next;
            }
            level = level.left;
        }
        return root;

    }
}