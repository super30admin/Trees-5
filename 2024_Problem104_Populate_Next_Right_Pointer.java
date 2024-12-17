//116. Populate Next Right Pointers in Each Node - https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
//Time Complexity: O(n)
//Space Complexity: O(n/2) ~ O(n)

//BFS: Level Order Traversal
class Solution {
    public Node connect(Node root) {
        //edge case
        if (root == null) {
            return root;
        }
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);

        while (!q.isEmpty()) {
            //get size of the level
            int size = q.size();
            for(int i=0; i<size; i++) {
                Node curr = q.poll();
                if (i < size - 1) {
                    curr.next = q.peek();
                    //process left
                }if (curr.left != null) {
                    q.add(curr.left);
                    //process right
                }if (curr.right != null) {
                    q.add(curr.right);
                }
            }
        }
        return root;
    }
}

//Optimal: No Extra Space
//Time Complexity: O(n)
//Space Complexity: O(1)
class Solution {
    public Node connect(Node root) {
        //base case
        if(root == null) return root;

        Node level = root;
        //while there is a next level
        while(level.left != null){
            Node curr = level;
            while(curr != null){
                //for siblings
                curr.left.next = curr.right;
                if(curr.next != null){
                    //for cousin nodes
                    curr.right.next = curr.next.left;
                }
                curr = curr.next;
            }
            level = level.left;
        }
        return root;
    }
}