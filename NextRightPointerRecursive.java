//TC : O(n) , n - number of nodes in tree
//SC : O(1) , excluding the O(2^h) recursive stack space

class Solution {
    public Node connect(Node root) {
        if(root == null)
            return null;
        
        Node temp = root,current;
        
        while(temp.left!=null){ // Since we are joining nodes in next level, check temp.left
            current = temp;
            
            //Set the directions
            while(current!=null){
                current.left.next = current.right;
                if(current.next!=null){
                    current.right.next = current.next.left; 
                } 
                current = current.next;
            }
            
            //Move to the next level
            temp = temp.left;
        }
        
        return root;
        
    }
}