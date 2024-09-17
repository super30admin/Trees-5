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

// Time complexity: O(n)
// Space complexity: O(n)

class Solution {

    TreeNode firstNode, secondNode, previousNode;

    public void recoverTree(TreeNode root) {

        firstNode = null;
        secondNode = null;
        previousNode = new TreeNode(Integer.MIN_VALUE);

        TreeNode cursor = root;
        Stack<TreeNode> stack = new Stack();

        while(cursor != null){
            stack.push(cursor);
            cursor = cursor.left;
        }

        while(!stack.isEmpty()){
            cursor = stack.pop();
            if(firstNode == null && previousNode.val > cursor.val){
            firstNode = previousNode;
        }

         if(firstNode != null && previousNode.val > cursor.val){
            secondNode = cursor;
        }
        previousNode = cursor;

        if(cursor.right != null){
            cursor = cursor.right;
            while(cursor!=null){
                stack.push(cursor);
                cursor = cursor.left;
                }
            }
        }

        swap(firstNode, secondNode);

    }

    private void swap(TreeNode a, TreeNode b){
        int val = a.val;
        a.val = b.val;
        b.val = val;
    }
}