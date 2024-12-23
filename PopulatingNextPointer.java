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
// Approach: BFS - Level Order traversal
// Time : O(n)
// Space : O(n/2)
class Solution {
    public Node connect(Node root) {
        if(root==null) return null;
       Queue<Node> q = new LinkedList<>();
       q.add(root);
       while(!q.isEmpty()){
        int size = q.size();
        for(int i =0;i<size;i++){
            Node curr = q.poll();
            if(i != size-1){
                curr.next = q.peek();
            }
            if(curr.left != null){
                q.add(curr.left);
                q.add(curr.right);
            }
        }
       }
       return root;

    }
}

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
// Approach : Using BFS but avoid extra space of queue.
// time : O(n)
// space : O(1) 
class Solution {
    public Node connect(Node root) {
        if(root == null) return root;
        Node level = root;
        while(level.left != null){
            Node curr = level;
            while(curr!=null){
                curr.left.next = curr.right;
                if(curr.next!=null){
                    curr.right.next = curr.next.left;
                }
                curr = curr.next;
            }
            level = level.left;
        }
        return root;
    }
}

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
// Approach: Using BFS with queue - Level Order traversal
// Time : O(n)
// Space : O(n/2)
class Solution {
    public Node connect(Node root) {
        if(root==null) return null;
       Queue<Node> q = new LinkedList<>();
       q.add(root);
       while(!q.isEmpty()){
        int size = q.size();
        for(int i =0;i<size;i++){
            Node curr = q.poll();
            if(i != size-1){
                curr.next = q.peek();
            }
            if(curr.left != null){
                q.add(curr.left);
                q.add(curr.right);
            }
        }
       }
       return root;

    }
}

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
// Approach : Using DFS
// Time : O(n)
// Space : O(h) # recursive stack space
class Solution {
    public Node connect(Node root) {
        if(root == null) return root;
        helper(root);
        return root;
    }
    public void helper(Node curr){
        // base case
        if(curr.left == null) return;

        // logic
        curr.left.next = curr.right;
        if(curr.next!=null){
            curr.right.next = curr.next.left;
        }
        // recursion
        helper(curr.left);
        helper(curr.right);
    }
}

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
// Approach : Using DFS but applying the logic of symmetric tree.
// Standing at children and we form connections directly.
// Time : O(n)
// Space : O(h) # recursive stack space
class Solution {
    public Node connect(Node root) {
        if(root == null) return root;
        helper(root.left,root.right);
        return root;
    }
    public void helper(Node left,Node right){
        // base case
        if(left == null) return;

        // logic
        left.next = right;
        // recursion
        helper(left.left,left.right);
        helper(left.right,right.left);
        helper(right.left,right.right);
    }
}