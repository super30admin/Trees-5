// Time Complexity : O(n), where n is the number of nodes in the tree
// Space Complexity : O(n), where n is the number of nodes in the tree (since it is perfect binary tree, there will atmost be n/2
                        // nodes in the queue)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Correct me on the space complexity

//Three Liner approcah of your code in plain English
//Perform BFS starting from the root node.
//Maintain a size variable to process all the nodes together at the same level
//Till queue is not empty remove the element add all its children and populate the next pointer from the current node to the node
        //on the top of the queue (Only if the current node is not the last node at that level)

// Your code here along with comments explaining your approach

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
        if(root == null) return null;
        
        //create a queue to perform BFS
        Queue<Node> bfs = new LinkedList<>();
        //add the root to the queue to start BFS
        bfs.add(root);
        
        while(!bfs.isEmpty()){
            //get the queue size, to process all the nodes together at the same level
            int size = bfs.size();
            for(int i=0; i<size; i++){
                //pop the element from the queue
                Node curr = bfs.poll();
                //add all the childs of the node in the queue
                if(curr.left != null){
                    bfs.add(curr.left);
                    bfs.add(curr.right);
                }
                //populate the next right pointer, if the node is not the last node at that level
                if(i < size-1){
                    curr.next = bfs.peek();
                }
            }
        }
        return root;
    }
}