

//Approach - 1: Queue, prev, curr 
//Time Complexity : O(n)
//Space Complexity : O(n)
class Solution {
    public Node connect(Node root) {
        
        if(root == null) return null;
        
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        Node prev = null;
        
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                Node curr = q.poll(); 
                if(i!=0){
                    //Pointing next node
                    prev.next = curr;
                }
                //add the childrens
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
                prev = curr;       
            }
         }
         
         return root;
    }
}



//Approach - 1.1: Queue, prev, curr 
//Time Complexity : O(n)
//Space Complexity : O(n)
class Solution {
    public Node connect(Node root) {
        
        if(root == null) return null;
        
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        
        
        while(!q.isEmpty()){
            int size = q.size();
            Node prev = null;
            for(int i=0; i<size; i++){
                Node curr = q.poll(); 
                
                if(prev!= null){
                    //Pointing next node
                    prev.next = curr;
                }
                //add the childrens
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
                prev = curr;       
            }
         }
         
         return root;
    }
}
