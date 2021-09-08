//Time complexity: O(N)
//Space complexity: O(1)

//Approach: 2 variables, level and curr
//if u are at root, u have access to left and right so connect them!
//children are connected but how do we connect cousins?
//curr.next.right = curr.next.left
//check if curr.next is null since curr is a right node


class Solution {
    public Node connect(Node root) {
        if(root == null)
            return root;
        
        Node level = root;
    
        while(level.left != null){
            Node curr = level;
            
            while(curr != null){
                //connecting left node to its right
                curr.left.next = curr.right;
            
                //right to next node's left
                if(curr.next != null)
                    curr.right.next = curr.next.left;
                curr = curr.next;
            }
            
            level = level.left;
        }
        return root;  
        
    }
}