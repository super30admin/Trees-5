// Time Complexity : O(n) where n is the number of nodes in the tree in both the approaches
// Space Complexity :
/*              Approach 1: Using Queue:  O(n) where n is the number of nodes in Queue
                Approach 2: No queue: O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Previous pointer needs to update its children in the queue
/* Your code here along with comments explaining your approach: As we move level by level, add the nodes to the queue. The very first node of
every level indicated by previous pointer, sets the children into the queue and updates the next pointer in approach 1 and in approach 2, level pointer
traverses as linked list at each level while previous pointer takes care of the level by level traversal  till it becomes null. Level pointer uses
its left, right and next pointers to update the next pointer of its children.
*/

// APPROACH 1: USING QUEUE
class Solution {
    public Node connect(Node root) {
        if(root == null) { return null;}
        Queue<Node> q = new LinkedList<>();                                             // Level order traversal
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();                                                                // size pointer
            Node prev = q.poll();
            if(prev.left != null){q.add(prev.left);}                                            // Add the children of the previous pointer
            if(prev.right != null){q.add(prev.right);}
            for(int i = 1; i < size; i++){
            Node curr = q.poll();                                                           // Get the next of the previous pointer
            prev.next = curr;                                                               // Connect the previous pointer and current node
            prev = curr;                                                                            // Repeat the above steps as you get more nodes in the same level
            if(curr.left != null){q.add(curr.left);}
            if(curr.right != null) {q.add(curr.right);}                                             // Add the children of current pointer
        }
        }
        return root;
    }
}

// APPROACH 2: WITHOUT QUEUE
class Solution {
    public Node connect(Node root) {
        if(root == null) {return null;}
        Node level = root;                                                                  // Will act as Linked List at each level
        Node prev = root;                                                                   // Will move down level by level
        while(level.left != null){
            prev = prev.left;                                                                   // moving down
            while(level != null){
            if(level.left != null){
                level.left.next = level.right;                                                      // Setting the left child's next pointer
            }
            if(level.right != null && level.next != null)                                   // Validation checks of bounds
                level.right.next = level.next.left;                                                     // Setting the right child's next pointer
            level = level.next;                                                                 // Level moving to the next node in the same level
            }
            level = prev;                                                                   // Level moving as the head to the next level's linked list starting from prev
        }
        return root;
    }
}