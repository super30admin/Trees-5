
// Time Complexity :  O(N) 
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode :Yes

class Solution {
    public Node connect(Node root) {
        if(root == null) return null;
        Node level = root;
        while(level.left != null){
            Node curr = level;
            while(curr != null){
                curr.left.next = curr.right;
                if(curr.next != null){
                    curr.right.next = curr.next.left; 
                }
                curr = curr.next;
            }
            level = level.left;
        }
        return root;
    }
    
}


//queue approach
// time and space O(N)
// class Solution {
//     public Node connect(Node root) {
//         if(root == null) return null;
        
//         Queue<Node> q = new LinkedList<>();
//         q.add(root);
//         while(!q.isEmpty()){
//             int size = q.size();
//             for(int i = 0; i < size; i++){
//                 Node curr = q.poll();
//                 if(i != size - 1){
//                     curr.next = q.peek();
//                 }
//                 if(curr.left != null){
//                     q.add(curr.left);
//                     q.add(curr.right);
//                 }
//             }
//         }
//         return root;
//     }
    
// }