package Trees5;

import java.util.LinkedList;
import java.util.Queue;

public class question104_PopulatingNextRightPointersInEachNode {
    /* Created by palak on 7/29/2021 */

    /**
     * Definition for a Node.
     */
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    /**
     Level Order Traversal with Brute Force :
     This we will done using LinkedList and it will be level order traversal.

     Time Complexity: O(n)
     Space Complexity: O(k) ; total number of leaf nodes
     */
    public Node connect1(Node root) {
        if(root == null)    return null;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            Node prev = queue.poll();
            if(prev.left != null) {
                //add the babies of prev in queue (It is a level order traversal)
                queue.add(prev.left);
                queue.add(prev.right); //for right we dont need an additional check here because it is a perfect binary tree.
            }
            for(int i = 1; i < size ; i++) {
                Node curr = queue.poll();
                prev.next = curr;
                if(curr.left != null) {
                    // we also have to add the babies of current inside the queue (It is a level order traversal)
                    queue.add(curr.left);
                    queue.add(curr.right);
                }
                prev = curr;
            }
        }
        return root;
    }

    /**
     Level Order Traversal without extra space:
     This is the BEST solution.
     Time Complexity: O(n)
     Space Complexity: O(1)


     */
    public Node connect2(Node root) {
        if(root == null)    return null;
        Node level =  root;
        while(level.left != null) {
            Node curr = level;
            while(curr != null) {
                curr.left.next = curr.right;
                if(curr.next != null) {
                    curr.right.next = curr.next.left;
                }
                curr = curr.next;
            }
            level = level.left;
        }
        return root;
    }

    /**
     DFS:

     Time Complexity: O(n)
     Space Complexity: O(h)

     */
    public Node connect3(Node root) {
        if(root == null)    return null;
        dfs(root.left, root.right);
        return root;
    }
    private void dfs(Node left, Node right) {
        //Base
        if(left == null)    return;

        //Logic
        left.next = right;
        dfs(left.left, left.right);
        dfs(left.right, right.left);
        dfs(right.left, right.right);
    }

    public static void main(String[] args) {

    }
}
