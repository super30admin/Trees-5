// Time Complexity : O(n),number of nodes.
// Space Complexity : O(n/2),  queue will have n/2 elements at leaf level
// Did this code successfully run on Leetcode : yes
// Three line explanation of solution in plain english : Do BFS, and at each level connect the childs.

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
        if(root == null) return root;
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();
            
            for(int i = 0 ; i < size ; i++){
                Node curr = q.poll();
                if(i != size - 1){
                    curr.next = q.peek();
                }

                //add children
                if(curr.left != null){
                    q.add(curr.left);
                    q.add(curr.right); //since its a perfect binary tree, right child will present if left is present.
                }


            }
        }

        return root;
    }
}


//BFS Optimized
// Time Complexity : O(n),number of nodes.
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : yes
// Three line explanation of solution in plain english : replace queue with variables because we have the connection forming a linked list at each level in a tree.

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
        if(root == null) return root;
        Node level = root;
        Node curr = root;

        while(level.left != null){
            curr = level;
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
}


//DFS
//BFS Optimized
// Time Complexity : O(n),number of nodes.
// Space Complexity : O(h) 
// Did this code successfully run on Leetcode : yes

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
        if(root == null) return root;
        dfs(root);
        return root;
    }

    private void dfs(Node root){
        if(root.left == null) return;
        root.left.next = root.right;
        if(root.next != null){
            root.right.next = root.next.left;
        }

        dfs(root.left);
        dfs(root.right);
    }
}

//Another DFS - Just like mirror of tree.

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
        if(root == null) return root;
        dfs(root.left,root.right);
        return root;
    }

    private void dfs(Node left , Node right){
        if(left == null) return;

        left.next = right;
        dfs(left.left,left.right);
        dfs(left.right,right.left);
        dfs(right.left,right.right);
    }
}