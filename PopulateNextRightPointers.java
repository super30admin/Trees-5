package S30.Trees_5;

import java.util.LinkedList;
import java.util.Queue;

/*Solution 1 - BFS
Time Complexity : O(n)
Space Complexity : O(n) - Queue Space
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None
*/

/* Solution 2 - Level by Level connection
Time Complexity : O(n)
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None
*/

/* Solution 3 - DFS
Time Complexity : O(n)
Space Complexity : O(h) - recursive stack space
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None
*/

public class PopulateNextRightPointers {

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

    //Solution 1
    public Node connectBFS(Node root) {

        Queue<Node> queue = new LinkedList<>();
        if(root == null) return root;
        queue.offer(root);


        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                Node curr = queue.poll();
                if(i < size - 1) curr.next = queue.peek();
                if(curr.left != null) queue.offer(curr.left);
                if(curr.right != null) queue.offer(curr.right);
            }
        }
        return root;
    }

    //Solution 2
    public Node connectLevelByLevel(Node root) {

        if(root == null) return root;
        Node level = root;

        while(level.left != null){

            Node curr = level;

            while(curr != null){

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

    //Solution 3
    public Node connectDFS(Node root) {

        if(root == null) return root;
        dfs(root.left, root.right);
        return root;
    }

    private void dfs(Node left, Node right){
        if(left == null && right == null) return;

        left.next = right;
        dfs(left.left, left.right);
        dfs(right.left,right.right);
        dfs(left.right,right.left);
    }
}
