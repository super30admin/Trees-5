/*

Iterative:
TC: O(N) N - number of nodes
SC: O(H) stack can have elements upto H.

1. Inorder traversal gives the order of elements in increasing order.
2. The order is not satisfied at two points.
3. Run the loop until we find second swapped node.

Recursion:
TC: O(N)
SC: O(H)

*/


import java.util.*;
public class RecoverBST {
   
    public void recoverTreeIterative(Node root){
        if(root == null) return;

        Node x = null, y = null, prev = null;

        Stack<Node> stk = new Stack<>();

        while(!stk.isEmpty() || root != null){
            while(root != null){
                stk.push(root);
                root = root.left;
            }
            root = stk.pop();
            if(prev != null && root.val < prev.val){
                x = root;
                if(y == null) y = prev;
                else break;
            }
            prev = root;
            root = root.right;
        }

        int temp = x.val;
        x.val = y.val;
        y.val = temp;
    }

    Node first = null, sec = null, pred = null;
    public void recoverRecursion(Node root){
        inorder(root);
        int temp = first.val;
        first.val = sec.val;
        sec.val = temp;
    }

    private void inorder(Node root){
        if(root == null) return;

        inorder(root.left);

        if(pred != null && root.val < pred.val){
            first = root;
            if(sec != null) sec = pred;
        }
        pred = root;

        inorder(root.right);
    }

}
