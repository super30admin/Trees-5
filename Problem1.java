/*
    LC - 116. Populating Next Right Pointers in Each Node
    TC - O(n)
    SC - O(1)
    Approach -
        Using iterative approach.
        traverse through the tree using left (which is root) and check next
        assign the pointers 
        and move forward
        return the root;
*/

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
        if(root == null) {
            return root;
        }
        Node left = root;
        while(left.left != null) {
            Node curr = left;
            while(curr != null) {
                curr.left.next = curr.right;
                if(curr.next!=null) {
                    curr.right.next = curr.next.left;
                }
                curr = curr.next;
            }
            left = left.left;
        }
        return root;
    }
}

/*
    LC - 116. Populating Next Right Pointers in Each Node
    TC - O(n)
    SC - O(h)
        bcs in stack at each time it will be max of h.
    Approach -
        using recursive traversal.
        pass both the root's left and right.
        call the recursive for left.left, left.right
        call the recursive for left.right, right.left
        call the recursive for right.left, right.right
*/

class Solution {
    public Node connect(Node root) {
        if(root == null) {
            return root;
        }
        dfs(root.left, root.right);
        return root;
    }
    public void dfs(Node left, Node right) {
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

