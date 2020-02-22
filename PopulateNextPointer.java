import java.util.Queue;
class Node {
    int val;
    Node next,left,right;
}

// Time Complexity : O(N) for Both Level and InOrder Traversal
// Space Complexity : O(log N) for Level Order Traversal,O(1) for Inorder Traversal
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

public class PopulateNextPointer {

    static boolean solveWithLevelOrderTraversal = true;
    public void populateNextPointer(Node root){
        if(root == null){
            return ;
        }
        if(solveWithLevelOrderTraversal){
            populateNextPointerLevelOrderTraversal(root);
        }
        else {
            populateNextPointerInOrderTraversal(root);
        }
    }

    public void populateNextPointerLevelOrderTraversal(Node root){
        Queue<Integer> queue = new LinkedList<>();

        queue.add(root);

        while(!queue.isEmpty()){
            Node node = queue.poll();;
            int size = queue.size();
            for(int i =0; i < size; i++){

                if(i < size - 1){
                    node.next = queue.peek();
                }
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
        }
    }

    public void populateNextPointerInOrderTraversal(Node root){
        Node current = root,currLevel = null;

        while(current.left != null){
            currLevel = root;
            while(currLevel != null){
                currLevel.left.next = currLevel.right;
                if(currLevel.next != null){
                    currLevel.right.next = currLevel.next.left;
                }
                currLevel = currLevel.next;
            }
            root = root.left;
        }
    }
}