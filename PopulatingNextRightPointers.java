


//Approach - 2 : Without Queue, prev, curr  , Best Approach ***
//Time Complexity : O(n)
//Space Complexity : O(1)
class Solution {
    public Node connect(Node root) {        
        //if root is null , return null node
        if(root == null) return null; 
        
        //level nodefor iterating each node
        Node level = root;

        //we will iterate til last child, i.e level.left != null
        while(level.left != null){
            
            //root ==> level ==> curr // node 1
            //Intialize curr for every level
            Node curr = level;

            //loop every level
            while(curr != null){               
                curr.left.next = curr.right;               
                //except last node 
                if(curr.next != null){
                  curr.right.next = curr.next.left;
                }                   
                curr = curr.next;
            }            
            //move to next level
            level = level.left;                
        }    
     return root;
    }
}




//Approach - 3 : DFS
//Time Complexity : O(n)
//Space Complexity : O(h)
class Solution {
    public Node connect(Node root) {
        if(root == null) return null;
        dfs(root);
        return root;
    }  

    private void dfs(Node root){
        if(root.left == null) return;
        
        root.left.next = root.right;
        
        if(root.next != null){
            root.right.next = root.next.left;
        }
        
        dfs(root.left);
        dfs(root.right);
        
    }
}



//Approach - 3.1 : dfs
//Time Complexity : O(n)
//Space Complexity : O(h)
class Solution {
    public Node connect(Node root) {        
        if(root == null) return null;
        dfs(root.left, root.right);
        return root;
    }
    private void dfs(Node left, Node right){
        //base
        if(left == null) return;
        
        left.next = right;
        //logic
        dfs(left.left, left.right);
        dfs(left.right, right.left);
        dfs(right.left, right.right);
        
    }
}



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


//Approach - 1.3: Queue, prev, curr  ***
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
                curr.next = prev;
                //add the childrens
                if(curr.left != null) q.add(curr.right);
                if(curr.right != null) q.add(curr.left);
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
