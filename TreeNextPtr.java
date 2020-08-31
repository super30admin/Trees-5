/*
  Time:O(n) n = number of nodes.
  Space:O(h) h = height of the tree.
  Run on LeetCode: Yes
*/
class Solution {
    //do a predorder traversal on tree and
    //on each parent make the connection for children next ptr.
    public Node connect(Node root) {
        if(root == null)
            return null;

        //connect left and right.
        if(root.left != null){
            root.left.next = root.right;
        }
        //connect, right with siblings left.
        if(root.right != null && root.next != null){
            root.right.next = root.next.left;
        }
        connect(root.left);
        connect(root.right);

        return root;
    }
}
