/*
o(n) time and const space
 */
class Solution {
    TreeNode first;
    TreeNode second;
    TreeNode prev;
    public void recoverTree(TreeNode root) {

        prev = null;
        first = null;
        second = null;
        inorder(root);
        int  temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
    private void inorder(TreeNode root){
        if(root == null) return;

        inorder(root.left);
        if(prev != null && first == null && root.val <= prev.val){
            first = prev;
            second = root;
        } else if(prev != null && first != null && root.val <= prev.val){
            second = root;
        }
        prev = root;

        inorder(root.right);
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
//o(n) time and O(n) space
class Solution {
    public Node connect(Node root) {
        if(root == null) return null;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        Node curr = null;
        while(!q.isEmpty()){
            int size = q.size();
            curr = q.poll();
            if(curr.left != null){
                q.add(curr.left);
            } if(curr.right != null){
                q.add(curr.right);
            }
            for(int i = 1; i < size; i++){
                Node temp = q.poll();
                curr.next = temp;
                curr = temp;
                if(curr.left != null){
                    q.add(curr.left);
                } if(curr.right != null){
                    q.add(curr.right);
                }
            }
        }
        return root;
    }
}