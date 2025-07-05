//Time Complexity: O(n)
//Space Complexity: O(n)

//BFS Method using Queue
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
        if(root == null)
            return null;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
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

//Method: BFS without Queue
//Time Complexityt: O(n)
//Space Complexity: O(1)

class Solution {
    public Node connect(Node root) {

        if(root == null)
            return null;
        Node level = root;
        while(level.left!= null){
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
}

//Method: DFS recursion method
//Time Complexityt: O(n)
//Space Complexity: O(h), here recursive stack space

class Solution {
    public Node connect(Node root) {

        if(root == null)
            return null;

        helper(root);
        return root;
        
    }

    public void helper(Node root){
        if(root.left == null)
            return;
        root.left.next = root.right;
        if(root.next != null){
            root.right.next = root.next.left;
        }

        helper(root.left);
        helper(root.right);
    }
}

//DFS Method  - it goes down both left and right subtrees. This is mirror image pattern

class Solution {
    public Node connect(Node root) {
        if(root == null)
            return null;

        helper(root.left, root.right);
        return root;
        
    }

    public void helper(Node left, Node right){
        if(left == null) // no need to check right because it perfect binary tree. If left is null thne right will also be null
            return;

        left.next = right;
        helper(left.left, left.right);
        helper(left.right, right.left);
        helper(right.left, right.right);

    }
}