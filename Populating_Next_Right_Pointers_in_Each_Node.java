// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;
    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }
    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/


//Keep track of a node for the level 
//till node level has children, populate its children as said
//get the first node (curr) of the level (same as level)
//for curr children, 
//point the curr nodes child (curr.left) to its right (do till curr node is not null (last node is null))
//if curr.next is not null, then there exists a cousin on same level, so get curr.next and do for all cousins 
//of level, point curr.right.next to curr.next.left
//and update curr to curr.next
//after level is completed, update level to level.next


class Solution {
    public Node connect(Node root) {
        if(root == null) return null;
        Node currLevel = root;
        while(currLevel.left != null) {
            Node curr = currLevel;
            while(curr != null) {
                curr.left.next = curr.right;
                if(curr.next != null) {
                    curr.right.next = curr.next.left;
                }           
                curr = curr.next;
            }
            currLevel = currLevel.left;      
        }                      
        return root;
    }
}


///////////////////////


// Time Complexity : O(n)
// Space Complexity : O(leaf nodes)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;
    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }
    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

//TC : O(n)
//SC : O(n)
//Use a queue and size variable, Add the root, 
//do till q is empty, get curr level size
//for the curr level, get the front of queue
//and till last popped node, get adjacent node (q.peek) and point curr node to the adjnode
//last node of the level should point to null, by default all nodes point to null
//so do nothing for last node of each level 
//add the children of curr node (if exists) to the queue
//in the end return the root


class Solution {
    public Node connect(Node root) {
        if(root == null) return null;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                Node curr = q.poll();
                if(i != size - 1) {
                    Node adjNode = q.peek();
                    curr.next = adjNode;
                }
                if(curr.left != null) {
                    q.add(curr.left);
                    q.add(curr.right);
                }                     
            }               
        }       
        return root;
    }
}