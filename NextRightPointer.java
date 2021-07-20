/* Approach BFS SC, TC - O(N)*/

class Solution {
    public Node connect(Node root) {
        // BFS 
        if (root == null) return root;
        Queue<Node> queue   = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for (int i  = 0; i < size; i++){
                
                Node elem = queue.poll();
                if (i < size-1){
                    elem.next = queue.peek();
                }
                if (elem.left != null){
                    queue.add(elem.left);
                    queue.add(elem.right);
                }
            }
        }
        return root;
    }
}


/* 2 pointer approach O(N) , SC - O(1)*/
class Solution {
    public Node connect(Node root) {
        // BFS with no extra space, using pointers to navigate 
        if (root == null) return root;
        Node level = root; 
        while(level.left != null){
            
            Node curr = level;
            
            while(curr != null){
                 curr.left.next = curr.right;
                if (curr.next != null){
                    curr.right.next = curr.next.left;
                    
                }
                curr = curr.next;
            } 
            level = level.left;
        }       
        return root;
    }
}


