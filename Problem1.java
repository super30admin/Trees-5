//TC : O(N)
//SC : O(N) using stack .

//LC RUN : YES

// IDEA : if node has the right,  assign the left next to right.
// if node next is not null , then assing the node right next to  node next left.
// the Traversal here it is  Root , Right , Left ( Tweaked pre order)



/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
class Solution {
    public Node connect(Node root) {
        Stack<Node> st = new Stack<>();
        st.push(root);
        while(!st.isEmpty()){
            Node n = st.pop();
            if (n != null) {
            if (n.right != null) {
                n.left.next = n.right;
                if (n.next != null) {
                    n.right.next = n.next.left;
                }
            }
            st.push(n.right);
            st.push(n.left);
            }  
            
        }
        
        return root;
        
    }
}
