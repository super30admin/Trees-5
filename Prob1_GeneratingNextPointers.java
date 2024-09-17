
//DFS  - with 2 Variables in Recursion
// Time Complexity : O(N)
// Space Complexity : O(H) === O(Log N base 2)

// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach


class Solution {
    public Node connect(Node root) {
        if(root == null)    return root;
        
        DFS(root.left, root.right);
        
        return root;
    }
    public void DFS(Node LeftNode, Node RightNode){
        if(LeftNode == null)   return;
       
        LeftNode.next = RightNode;
        
        DFS(LeftNode.left, LeftNode.right);
        DFS(LeftNode.right, RightNode.left);
        DFS(RightNode.left, RightNode.right);
    }
}



//DFS  - with 1 Variable in Recursion
// Time Complexity : O(N)
// Space Complexity : O(H) === O(Log N base 2)

// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

/*
class Solution {
    public Node connect(Node root) {
        if(root == null)    return null;
        helper(root);
        
        return root;
    }
    public void helper(Node root){
        if(root.left == null)    return; // Perfect binary tree so either 0 children or 2 children for each node
        
        root.left.next = root.right;
        if(root.next != null){
            root.right.next = root.next.left;
        }
        
        helper(root.left);
        helper(root.right);
    }
}

*/



/*
    
//BFS without Creating Extra space for Queue
// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {
    public Node connect(Node root) {
        if(root == null)    return root;
        
        Node level = root;
        Node curr = root;
        while( level != null ){
            curr = level;
            
            while(curr != null && curr.left != null){ // Perfect binary tree so either 0 children or 2 children for each node
                curr.left.next = curr.right;
                if(curr.next != null){
                    curr.right.next = curr.next.left;
                }
                curr = curr.next;
            }
            level = level.left;
        }
        
        return root;
    }
}

*/




/*
//BFS 
// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach


class Solution {
    public Node connect(Node root) {
        if(root == null)    return root;
        
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        
        while( !queue.isEmpty() ){
            int len = queue.size(); // Len  times we will pull the node from queue and will set the next pointer link
            for(int i = 0; i< len; i++){
                Node curr = queue.poll();
                if(i != len - 1)
                    curr.next = queue.peek();
                
                if(curr.left != null ){ // Perfect binary tree so either 0 children or 2 children for each node
                    queue.add(curr.left);
                    queue.add(curr.right);
                }
            }
        }
        
        return root;
    }
}

*/