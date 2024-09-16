
// Time Complexity :O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//in this solution we dont need exta space as we are usign pointers to save current and level
public Node Connect(Node root) {
    if(root == null)
        return root;
    
    //level pointer used to traverse all levels
    Node lvl = root;
    //current pointer used to traverse all node at each level
    Node curr = root;
    
    while(lvl.left != null)
    {
        curr = lvl;
        while(curr != null)
        {
            curr.left.next = curr.right;
            if(curr.next != null){
                curr.right.next = curr.next.left;
            }
            curr = curr.next;
        }
        lvl = lvl.left;
    }
    
    return root;
            return root;
}


// 1) Do level order traversal - BFS
// 2) Then just point current to next element using temp variable
//TC: O(n)
//SC: O(n)
public class Solution {
    public Node Connect(Node root) {
    if(root == null)
        return root;

    Queue<Node> queue = new Queue<Node>();
    queue.Enqueue(root);
    
    while(queue.Count > 0)
    {
        //we take queue count before adding right and left to queue
        //because every level need to be processed for each count
        int size = queue.Count;
        var curr = queue.Dequeue();
        if(curr.left != null)
            queue.Enqueue(curr.left);
        if(curr.right != null)
            queue.Enqueue(curr.right);
        
        //we already processed first root, we start i = 1
        for(int i = 1; i < size; i++)
        {
            var temp = queue.Dequeue();
            curr.next = temp;
            curr = temp;
            
            if(curr.left != null)
                queue.Enqueue(curr.left);
            if(curr.right != null)
                queue.Enqueue(curr.right);
        
        }
    }
    return root;
}