// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
    We use a level order traversal to iterate through the tree.
    We connect the element to the next element in the Queue unless we hit the size of the queue.
*/

class Solution {
    
    List<List<Node>> levelOrderNodes;
    
    public Node connect(Node root) {
        Queue<Node> q = new LinkedList<>();
        if (root!=null)
            q.add(root);
        
        while(q.size() != 0){
            
            int levelSize = q.size();
                
            Node node1 = q.poll();
            if (node1.left != null && node1.right != null){
                q.add(node1.left);
                q.add(node1.right);
            }

            for (int i = 1; i<levelSize; i++) {
                Node node2 = q.poll();
                if (node2.left != null && node2.right != null){
                    q.add(node2.left);
                    q.add(node2.right);
                }
                node1.next = node2;
                node1 = node2;
            }
            
            node1.next = null;
        }
        return root;
    }
}