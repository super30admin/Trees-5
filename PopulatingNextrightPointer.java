// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

public class PopulatingNextrightPointer {
    class Solution {
        public Node connect(Node root) {
            if(root == null)
                return null;

            Node head = root;
            // Queue<Node> q = new LinkedList<>();
            // q.add(root);

            // while(!q.isEmpty()){
            //     int size = q.size();
            //     for(int i = 0; i < size; i++){
            //         Node popped = q.poll();
            //         if(i != size-1){
            //             popped.next = q.peek();
            //         }
            //         if(popped.left != null){
            //             q.add(popped.left);
            //         }
            //         if(popped.right != null){
            //             q.add(popped.right);
            //         }
            //     }
            // }

            while(root.left != null){
                Node curr = root;
                while(curr != null){
                    curr.left.next = curr.right;
                    if(curr.next != null){
                        curr.right.next = curr.next.left;
                    }
                    curr = curr.next;
                }
                root = root.left;
            }
            return head;
        }
    }
}
