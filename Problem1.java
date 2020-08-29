// There are three approaches
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

import java.util.LinkedList;
import java.util.Queue;

// Your code here along with comments explaining your approach
// Approach 1: Using BFS(level order traversal)
// Time Complexity : O(n)
//      n: number of elements in the tree
// Space Complexity : O(w) = O(2^h)
//      w: width of the tree
//      h: height of the tree
//   Here height is log n since it is perfect Binary Tree
class Problem1S1 {
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

    /** Connect nodes by level */
    public Node connect(Node root) {
        
        // edge case
        if(root!= null && root.left!=null && root.right != null ){

            // Queue for BFs
            Queue<Node> myQueue = new LinkedList<>();
            myQueue.add(root);

            // for size and curent node
            int size;
            Node current;

            // iterate elements of tree
            while(!myQueue.isEmpty()){

                // size of level order
                size = myQueue.size();
                size -= 1; // for last node as we dont need to link its next
                while(size != 0){

                    // link current node
                    current = myQueue.poll();
                    current.next = myQueue.peek();

                    // process current node
                    if(current.left != null){
                        myQueue.add(current.left);
                        myQueue.add(current.right);
                    }
                    size--; // reduce size
                }
                // for last node of the level (also root of the tree)
                current = myQueue.poll();
                // process last node of a level
                if(current.left != null){
                        myQueue.add(current.left);
                        myQueue.add(current.right);
                }
            }
        }
        // return tree
       return root; 
    }
}
// Your code here along with comments explaining your approach
// Approach 2: Using DFS
// Recursive connect parent's left and right children
// Time Complexity : O(n)
//      n: number of elements in the tree
// Space Complexity : O(h)
//      h: height of the tree
//   Here height is recursive stack space which is log n since it is perfect Binary Tree
//   if we don't consider recursive stack space it is O(1)
class Problem1S2 {
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

    /** Connect node by level */
    public Node connect(Node root) {
        // edge case
        if(root!= null && root.left!=null && root.right != null )
            dfs(root.left, root.right); // connect left and right
        return root;
    }

    /** Depth first Traversal */
    private void dfs(Node left, Node right){
        // base case
        if(left == null)
            return;
        // connect left to right
        left.next = right;
        // for children
        // connect left's left to left's right 
        dfs(left.left, left.right);
        // connect left's right to right's left
        dfs(left.right, right.left);
        // connect right's left to right's right
        dfs(right.left, right.right);
    }
}

// Your code here along with comments explaining your approach
// Approach 3: Using BFS without queue(using pointers)
// At particualr level, connect all the children nodes
// Recursive connect parent's left and right children
// Time Complexity : O(n)
//      n: number of elements in the tree
// Space Complexity : O(1)
//     Only pointers no extra ADT structure
class Problem1S3 {
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

    /** connect nodes by level */
    public Node connect(Node root) {

        // edge case
        if(root != null ){

            // start from top level and connect its children
            Node level = root;
            Node current; // for iterating all connected nodes
            // till it reaches (leaf-level)-1 i.e. (h-1) level
            while(level.left != null){ 
                
                current = level;
                
                // iterating all the nodes of particular level 
                while(current != null ){ 

                    // link left with right
                    current.left.next = current.right;

                    // check next present, link right
                    if(current.next != null)
                        current.right.next = current.next.left;

                    // update current
                    current = current.next;
                }
                
                // update level
                level = level.left;
            }
        }
        // return tree
        return root;
    }
}