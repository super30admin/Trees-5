/*
The following code utilizes a top-down BFS approach o solve the problem. At each level starting from the top,
The left and right children of each node at that level are connected together. Once this is done for the current
level, the algorithm traverses down and recursively computes all the levels till we reach the end.

This problem can also be solved with a regular BFS using a queue in O(n) space, and with DFS using O(h) space.

Did this code run on leetcode: Yes
*/

class Solution {
    //Time Complexity: O(n)
    //Space Complexity: O(1)
    public Node connect(Node root) {
        
        if(root == null)
            return root;
        
        Node level = root;
        
        while(level.left != null)
        {
            Node curr = level;
            
            while(curr != null)
            {
                curr.left.next = curr.right;
                //For the nodes beyond the second level, the right child of the current node has to be connected to the 
                //left child of the next node.
                if(curr.next != null)
                    curr.right.next = curr.next.left;

                curr = curr.next;
            }
            level = level.left;
        }
        
        return root;
    }
}