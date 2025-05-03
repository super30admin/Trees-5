

/*
//Definition for a Node.
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

//BFS using queue
/*
class Solution {
 public Node connect(Node root) {
     if(root==null){
         return root;
     }
     Queue<Node> q=new LinkedList<>();
     q.add(root);
     while(!q.isEmpty()){
         int size=q.size();
         for(int i=0;i<size;i++){
             Node curr=q.poll();
             if(i!=size-1){
                 curr.next=q.peek();
             }
             if(curr.left!=null){
                 q.add(curr.left);
                 //every node has 2 child or no child
                 q.add(curr.right);
             }
             
         }
     }
     return root;
 }
}
*/
/*
//BFS with no extra space
class Solution {
 public Node connect(Node root) {
     if(root==null){
         return root;
     }
     Node level=root;
     while(level.left!=null){
         Node curr=level;
         while(curr!=null){
             curr.left.next=curr.right;
             if(curr.next!=null){
                 curr.right.next=curr.next.left;
             }
              curr=curr.next;
         }
         
         level=level.left;   
     }
     return root;
 }
}
*/
/*
//DFS
//TC: O(n)
//SC: O(logn)
class Solution {
 public Node connect(Node root) {
     if(root==null){
         return root;
     }
     helper(root.left,root.right);
     return root;
 }
 //1
 /*
 private void helper(Node left, Node right){
     if(left==null){
         return;
     }

     //logic
     left.next=right;
     helper(left.left,left.right);
     helper(left.right,right.left);
     helper(right.left,right.right);
 }
 */
 /*
 //2
 private void helper(Node left, Node right){
     if(left==null){
         return;
     }

     //logic
     
     helper(left.left,left.right);
     left.next=right;
     helper(left.right,right.left);
     helper(right.left,right.right);
 }
 */
 /*
 //3
 private void helper(Node left, Node right){
     if(left==null){
         return;
     }

     //logic
     
     helper(left.left,left.right);
     
     helper(left.right,right.left);
     left.next=right;
     helper(right.left,right.right);
 }
 */
 /*
 //4
 private void helper(Node left, Node right){
     if(left==null){
         return;
     }

     //logic
     
     helper(left.left,left.right);
     
     helper(left.right,right.left);
     
     helper(right.left,right.right);
     left.next=right;
 }
}
*/
class PopulateNextRightPointer {
 public Node connect(Node root) {
     if(root==null){
         return root;
     }
     helper(root);
     return root;
 }
 
 private void helper(Node root){
     if(root.left==null){
         return;
     }
     //logic

     root.left.next=root.right;
     if(root.next!=null){
         root.right.next=root.next.left;
     }
     helper(root.left);
     helper(root.right);
 }


 //inorder wont work
 // private void helper(Node root){
 //     if(root.left==null){
 //         return;
 //     }
 //     //logic

     
 //     helper(root.left);
 //     root.left.next=root.right;
 //     if(root.next!=null){
 //         root.right.next=root.next.left;
 //     }
 //     helper(root.right);
 // }

 //inorder works
 // private void helper(Node root){
 //     if(root.left==null){
 //         return;
 //     }
 //     //logic

 //     root.left.next=root.right;
 //     helper(root.left);      
 //     if(root.next!=null){
 //         root.right.next=root.next.left;
 //     }
 //     helper(root.right);
 // }

 //postorder wont work
 // private void helper(Node root){
 //     if(root.left==null){
 //         return;
 //     }
 //     //logic

 //     helper(root.left);      
 //     helper(root.right);
 //     root.left.next=root.right;
 //     if(root.next!=null){
 //         root.right.next=root.next.left;
 //     }
 // }

 //postorder wont work too
 // private void helper(Node root){
 //     if(root.left==null){
 //         return;
 //     }
 //     //logic
 //     root.left.next=root.right;
 //     helper(root.left);      
 //     helper(root.right);
 //     if(root.next!=null){
 //         root.right.next=root.next.left;
 //     }
 // }
}