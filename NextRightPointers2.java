// Time Complexity : O(n), n = number of nodes
// Space Complexity : O(n), n = number of leaf nodes
// Did this code successfully run on Leetcode : Yes

class Solution {
    public Node connect(Node root) {
        if(root == null)
            return root;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            Node prev = queue.poll();
            int size = queue.size();
            if(prev.left != null) {
                queue.add(prev.left);
                queue.add(prev.right);
            }
            for(int i=0; i<size; i++) {
                Node curr = queue.poll();
                prev.next = curr;
                if(curr.left != null) {
                    queue.add(curr.left);
                    queue.add(curr.right);
                }
                prev = curr;
            }
        }
        return root;
    }
}