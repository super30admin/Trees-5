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

//bfs using queue, tc-O(n) sc - o(n/2)

// class Solution {
//     public Node connect(Node root) {
//         if(root == null) return null;
//         Queue<Node> q = new LinkedList<>();

//         q.add(root);

//         while(!q.isEmpty()){
//             int size = q.size();

//             for(int i = 0; i < size; i++){
//                 Node curr = q.poll();
//                 if(i != size-1){
//                     curr.next = q.peek();
//                 }
//                 if(curr.left!=null){
//                     q.add(curr.left);
//                     q.add(curr.right);

//                 }
//             }
//         }

//         return root;
        
//     }
// }

//without extra space bfs

// class Solution {
//     public Node connect(Node root) {
//         if(root == null) return null;

//         Node level = root;

//         while(level.left != null){
//             Node curr = level;
//             while(curr != null){
//                 curr.left.next = curr.right;
//                 if(curr.next != null){
//                     curr.right.next = curr.next.left;
                    
//                 }
//                 curr = curr.next;
//             }
//             level = level.left;
//         }
//         return root;
        
//     }
// }


// //dfs solution tc- O(n) sc-O(h)
// class Solution {
//     public Node connect(Node root) {
//         if(root == null) return null;

//         helper(root);

//         return root;
        
//     }

//     private void helper(Node curr){
//         //base
//         if(curr.left == null) return;

//         //logic
//         curr.left.next = curr.right;
//         if(curr.next != null){
//             curr.right.next = curr.next.left;
//         }

//         helper(curr.left);
//         helper(curr.right);
//     }
// }


//2 bfs 2 dfs algo solution or symmatric tree ligic tc- O(n) sc-O(h)
//in this approach we are not dependong on any previous connections so, preorder, post and in all will work

class Solution {
    public Node connect(Node root) {
        if(root == null) return null;

        helper(root.left, root.right);

        return root;
        
    }

    private void helper(Node left, Node right){
        //base
        if(left == null) return;

        //logic
        left.next = right;
       
        helper(left.left, left.right);
        helper(left.right, right.left);
        helper(right.left, right.right);
    }
}

