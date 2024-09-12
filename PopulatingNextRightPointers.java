Time Complexity = O(n) where n is number of nodes in tree
Space Complexity = O(n)

//Level-Order Traversal
class Solution {
    public Node connect(Node root) {
        if(root == null){
            return null;
        }
        
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                Node current = q.remove();
                
                if(current.left != null){
                    q.add(current.left);
                }
                
                if(current.right != null){
                    q.add(current.right);
                }
                
                if(i < size -1){
                    current.next = q.peek();
                }else{
                    current.next = null;
                }
            }
        }
        return root;
        
    }
}