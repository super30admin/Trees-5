//Time complexity: O(n) -> as checking each node
//Space Complexity: O(n) for level travelson using queue, O(1) for solutions using left and curr Nodes, O(h) recursive stack
//Did the code run successfully in LeetCode = yes


package com.madhurima;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointers {
}

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
}


class SolutionLevelOrderTravelsal {

    //level order travelsal
    public Node connect(Node root) {
        if(root == null){
            return root;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();
            Node curr = q.poll();
            if(curr.left != null){
                q.add(curr.left);
                q.add(curr.right);
            }

            for(int i = 0; i < size - 1; i++){
                Node next = q.poll();
                curr.next = next;
                if(next.left != null){
                    q.add(next.left);
                    q.add(next.right);
                }
                curr = next;
            }
        }

        return root;

    }
}

class SolutionNoExtraSpace {
    public Node connect(Node root) {
        if(root == null){
            return root;
        }

        Node left = root;
        Node curr = root;

        while(left.left != null){
            curr = left;
            while(curr != null){
                curr.left.next = curr.right;
                if(curr.next != null){
                    curr.right.next = curr.next.left;
                }
                curr = curr.next;
            }
            left = left.left;
        }

        return root;

    }
}

class SolutionDFS {

    //depth first
    public Node connect(Node root) {
        if(root == null){
            return root;
        }

        dfs(root.left, root.right);

        return root;
    }

    private void dfs(Node left, Node right){
        //base
        if(left == null){
            return;
        }

        //logic
        left.next = right;
        dfs(left.left, left.right);
        dfs(left.right, right.left);
        dfs(right.left, right.right);

    }

}
