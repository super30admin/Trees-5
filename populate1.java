//Time: O(N)
//Space: O(N) because of perfect binary tree O(N/2)

//Approach: Queue with level order traversal
//Initially push root to the queue
//Poll it and and first poll of the level is the head of the linked list
//perfect binary tree means all levels are filled: if it has a left, it has a right

class Solution {
    public Node connect(Node root) {
        if(root == null)
            return root;
        
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        
        while(!queue.isEmpty()){
            int sz = queue.size();
            Node prev = queue.poll();
            
            if(prev.left != null){
                queue.add(prev.left);
                queue.add(prev.right);
            }
            for(int i = 1; i < sz; i++){
                Node curr = queue.poll();
                prev.next = curr;
                if(curr.left != null){
                    queue.add(curr.left);
                    queue.add(curr.right);
                }
                
                prev = curr;
            }
        }
        return root;
    }
}