//BFS Solution(Optimal)
//Time: O(n)
//Space: O(1)

class Solution {
    public Node connect(Node root) {
        //null case check
        if(root == null) return root;
        
        //crerating a level node that will keep track of the level of the tree, initialzing it with the topmost root node
        Node level = root;
        
        //doing BFS until the second to last level, this is because at each level we will be connecting the respective right and left children nodes so we don't need to go to the last level
        while(level.left != null) {
            //pointing the curr element to the first element of each level
            Node curr = level;
            
            //looping until we reach.....
            while(curr != null) {
                //if we are at a left child, we connect it to the right child of the same node
                curr.left.next = curr.right;
                
                //for the cases where we have not reached the last node of the level
                //this is because we won't need to connect the right child of the last node of level any further
                if(curr.next != null) {
                    //if we are at a right child, we connect it to the left child of the node to its right
                    curr.right.next = curr.next.left;
                }
                //iterating the curr pointer further on the same levle
                curr = curr.next;
            }
            //moving to the next level on the tree
            level = level.left;
        }
        
        return root;
    }
}