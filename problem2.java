//Problem2 - https://leetcode.com/problems/populating-next-right-pointers-in-each-node/

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this: No
public class problem2 {
    public Node connect(Node root) {
        if(root == nu;;) return root;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmptty()){
            int size = q.size();
            Node prev = null;
            for(int i=0;i<size;i++){
                Node curr = q.poll();
                if(i != 0){
                    prev.next = curr;
                }
                if(curr.left != null){
                    q.add(curr.left);
                    q.add(curr.right);
                }
                prev = curr;
            }
        }
        return root;
    }
}}
