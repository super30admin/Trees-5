// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach:
//See attached diagram

lass Solution {
    //T: O(N)
    //S: O(1)
    public Node connect(Node root) {
       //base check
        if(root == null) return root;
        
        //copy the root to keep track of level and cursor
        Node firstNodeLevel = root;
        
        //loop until left node of firstNodeLevel is not NULL. Since, this is a perfect binary, this condition will work
        while(firstNodeLevel.left != null){
            
            //copy the firstNodeLevel to cursor to connect the nodes
            Node cursor = firstNodeLevel;
            
            //connect pointers until cursor is not null
            while(cursor != null){
                //connection with direct child nodes
                cursor.left.next = cursor.right;
                
                //connection with adjacent child nodes
                if(cursor.next != null){
                    cursor.right.next = cursor.next.left;
                }
                
                //connect the adjacent node's direct child nodes
                cursor = cursor.next;
            }
            
            //move to next level
            firstNodeLevel = firstNodeLevel.left;
        }
        
        return root;
    }
}