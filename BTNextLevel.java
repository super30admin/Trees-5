import java.util.*;
public class BTNextLevel{
    /**
     * Time Complexity : O(n) where n is the number of nodes 
     * Space Complexity : O(n)
     */
    public Node connect(Node root) {
        if(root == null) { return null;}
        Queue<Node> q = new LinkedList<>();                                             
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();                                                               
            Node prev = q.poll();
            if(prev.left != null){q.add(prev.left);}                                            
            if(prev.right != null){q.add(prev.right);}
            for(int i = 1; i < size; i++){
            Node curr = q.poll();                                                           
            prev.next = curr;                                                               
            prev = curr;                                                                            
            if(curr.left != null){q.add(curr.left);}
            if(curr.right != null) {q.add(curr.right);}                                             
        }
        }
        return root;
    }


    public Node connect2(Node root) {
        /**
        * Time Complexity : O(n) where n is the number of nodes 
        * Space Complexity : O(1)
        */
        if(root == null) {return null;}
        Node level = root;                                                                  
        Node prev = root;                                                                  
        while(level.left != null){
            prev = prev.left;                                                                   
            while(level != null){
            if(level.left != null){
                level.left.next = level.right;                                                      
            }
            if(level.right != null && level.next != null)                                   
                level.right.next = level.next.left;                                                
            level = level.next;                                                                 
            }
            level = prev;                                                                   
        }
        return root;
    }

}

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