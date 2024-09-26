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

// TC - O(n)
// SC - O(1)
 
// LC - 116

class Solution {
    public Node connect(Node root) {
		// Sainty check
        if(root == null){
            return null;
        }     
		// Store root at level node, we are storing this to find starting node of each level. 
        Node level = root;
        while(level != null){
			// we initialize curr to level initially and it moves right ways till it's null
            Node curr = level;
            while(curr != null){
                if(curr.left != null){
					// Populating next pointers at current level
                    curr.left.next = curr.right;
                }
				// Populating next pointers at next current level
                if(curr.next != null && curr.right != null){
                    curr.right.next = curr.next.left;
                }   
                curr = curr.next;   
            }
            level = level.left;
        }
        return root;
    }
}

// class Solution {
//     public Node connect(Node root) {
//         if(root == null){
//             return null;
//         }
//         Queue<Node> q  = new LinkedList<>();
//         Node temp = root;
//         q.add(temp);
//         while(!q.isEmpty()){
//             int size = q.size();
//             for(int i=0; i<size; i++){
//                 Node poppedVal = q.remove();
//                 if(i+1 == size){
//                     poppedVal.next = null;
//                 }else{
//                     poppedVal.next = q.peek();
//                 }
//                 if(poppedVal.left != null){
//                     q.add(poppedVal.left);
//                 }
//                 if(poppedVal.right != null){
//                     q.add(poppedVal.right);
//                 }
//             }
//         }
//         return root;
//     }
// }