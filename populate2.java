//Time: O(N)
//Space: O(N)

class Solution {
    public Node connect(Node root) {
        if(root == null)
            return root;
        
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        
        while(!queue.isEmpty()){
            int sz = queue.size();
            
            for(int i = 0; i < sz; i++){
                
                Node curr = queue.poll();
                if( i != sz - 1){
                    curr.next = queue.peek();
                }
                
                if(curr.left != null){
                    queue.add(curr.left);
                    queue.add(curr.right);
                }
            }
        }
        return root;
        
    }
}