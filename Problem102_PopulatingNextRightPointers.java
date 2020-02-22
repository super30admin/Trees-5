//Time Complexity: O(n)
//Space Complexity: No extra Space used

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

class Solution {
    
    public void getNextPtr(Node root) {
    //edge case
    if(root == null)
        return;
        
    //recursive
    //if root has left
    if(root.left != null){
        //connect left child with right child
        root.left.next = root.right;
        //if root->next has some value (prev connection made between left and right)
        if(root.next != null)
            //connection between roots right child and prev right root's left child
            root.right.next = root.next.left;
    }
    
    getNextPtr(root.left);
    getNextPtr(root.right);
    }
    
    public Node connect(Node root) {
        
    getNextPtr(root);
    return root;
    }
}

/*************************************************************** */
//Time Complexity : O(n)
//Space Complexity: O(2^h) -> where h is the height
//using Breadth First Search

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

class Solution {
    public Node connect(Node root) {
        //edge case
        if (root == null) {
            return root;
        }
        //creating que for level order traversal
        Queue<Node> que = new LinkedList<Node>(); 
        que.add(root);
        
        // Outer while loop which iterates over 
        // each level
        while (que.size() > 0) {
            int size = que.size();            
            for(int i = 0; i < size; i++) {
                // Pop a node from the queue
                Node node = que.poll();
                if (i < size - 1) {
                    node.next = que.peek();
                }                
                // Add the children, if any
                //left child
                if (node.left != null) {
                    que.add(node.left);
                }
                //right child
                if (node.right != null) {
                    que.add(node.right);
                }
            }
        }
        return root;
    }
}