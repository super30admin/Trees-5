import java.util.*;

public class PopulateNextPointer {

    // TC: O(N) - Traversing all the elements in the tree.
    // SC: O(N) - As we are using queue extra space it will be O(N).
    public Node connectBF(Node root) {
        // Queue approach
        // Add it to the queue.
        // Get size and iterate all the elements and add the children the queue.
        // Two pointer - Update the previous and current.

        if (root == null)
            return root;

        Queue<Node> queue = new LinkedList();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Node current = null;
            Node previous = null;
            for (int i = 0; i < size; i++) {
                current = queue.poll();
                if (previous != null) {
                    previous.next = current;
                }
                previous = current;

                if (current.left != null) {
                    queue.add(current.left);
                }

                if (current.right != null) {
                    queue.add(current.right);
                }
            }
        }
        return root;
    }


    
    //O(N) and O(1) but works only  Perfect binary tree.
    public Node connect(Node root) {
        Node level = root;
         while (level != null) {
             Node current = level;
             while (current != null) {
                 if (current.left != null) {
                     current.left.next = current.right;
                 }
                 if (current.next != null && current.right != null ) {
                     current.right.next = current.next.left;
                 }
                 current = current.next;
             }
             level = level.left;
         }
         return root;
     }


     //Works all.
    //Three pointer approach.
    //Current - Moves next by next
    //Level - Moves level by level - It can be left or right but starting node. - Which is if we don't have any previous.
    //Previous - holds the previous value.
    //If we have not found the previous then it is level first node.
    //If previous is not null we should point next of it to current's next(left or right) node.
    //TC: O(N)- Traversing all the nodes
    //SC: O(1)-Iterative approach and no auxilary spaces so it will be constant time.
    public Node connectOptimal(Node node) {
        Node level = node;
        Node previous = null;
        while((level!=null && level.left !=null) || (level!=null && level.right!=null)) {
            Node current = level;
            previous = null;
            while(current!=null) {
                if(current.left!=null){
                    if(previous != null) {
                        previous.next = current.left;
                    } else{
                        level =  current.left;
                    }
                    previous = current.left;
                }
                if(current.right!=null){
                    if(previous != null) {
                        previous.next = current.right;
                    } else{
                        level =  current.right;
                    }
                    previous = current.right;
                }
                current = current.next;
            }
        }
        return node;
    }

    public static void main(String[] args) {
        PopulateNextPointer populateNextPointer = new PopulateNextPointer();
        Node node = new Node().getSampleNodeThree();
        populateNextPointer.connectOptimal(node);
        System.out.println("The result is" + node);
    }
}