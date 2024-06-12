import java.util.Queue;

/*
## Problem 1: Populating Next Right Pointers in Each Node
(https://leetcode.com/problems/populating-next-right-pointers-in-each-node/)

Time Complexity :   O (n) 
Space Complexity :  O (n) 
Did this code successfully run on Leetcode :    Yes (116. Populating Next Right Pointers in Each Node)
Any problem you faced while coding this :       No
 */
// Input: root = [1,2,3,4,5,6,7]
// Output: [1,#,2,3,#,4,5,6,7,#]
    
class NextRightPointer {
    public Node connect(Node root) {
        if(root == null){
            return root;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        
        while(!queue.isEmpty()){
            int size = queue.size();
            Node prev = null;
            
            for(int i=0; i< size; i++){
                Node curr = queue.poll();
                if(i != 0){
                    prev.next = curr;
                }
                
                if(curr.left != null){
                    queue.add(curr.left);
                    queue.add(curr.right);
                }
                prev = curr;
            }
        }
        return root;
    }
}