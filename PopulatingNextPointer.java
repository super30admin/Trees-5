/**
116. Populating Next Right Pointers in Each Node 

Leetcode: https://leetcode.com/problems/populating-next-right-pointers-in-each-node/

Time Complexity : O(N)
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No


**/

class Solution 
{
    public Node connect(Node root) 
    {
        Node leftNode = root;
        
        while(leftNode != null && leftNode.left!= null)
        {
            populateNextPointers(leftNode);
            
            leftNode = leftNode.left;
        }
        
        
        return root;
        
        
    }
    
    private void populateNextPointers(Node startNode)
    {
        
        
        Node temp = startNode;
        
        while( temp != null)
        {
        
            temp.left.next = temp.right;
            
            if( temp.next != null)
            {
                temp.right.next = temp.next.left;
            }
            
            temp = temp.next;
        
        }
    }
}