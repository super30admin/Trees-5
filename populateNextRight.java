//*116. Populating Next Right Pointers in Each Node
//Brut-force soultion
import java.util.*;

class Node {
    int val;
    Node next;
    Node left;
    Node right;
    Node() {}
    Node(int val) { this.val = val; }
    Node(int val, Node next, Node left, Node right) {
        this.val = val;
        this.next = next;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public Node connect(Node root) {
        Queue<Node> q = new LinkedList<>();
        if(root == null){
            return null;
        }
        q.add(root);
        while(!q.isEmpty()){
            int siz = q.size();
            for(int i = 0; i < siz; i++){
                Node current = q.poll();
                if(i != siz -1)
                current.next = q.peek();
            
            if(current.left != null){
                q.add(current.left);
            }
            if(current.right != null ){
                q.add(current.right);
            }
            }
        }
        return root;
    }
}


//Optimized soultion

class Solution1 {
    public Node connect(Node root) {
        if(root == null){
            return null;
        }
        Node level = root;
        while(level.left != null){
            Node current = level;
            while(current != null){
                current.left.next = current.right;
                if(current.next != null){
                    current.right.next = current.next.left;
                }
                current = current.next;
            }
            
            level= level.left;
        }
        
        return root;
    }
}