// Time Complexity : O(n), n = number of nodes
// Space Complexity : O(n), n = number of nodes
// Did this code successfully run on Leetcode : Yes

class Solution {
    public Node connect(Node root) {
        if(root == null)
            return root;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0; i<size; i++) {
                Node curr = queue.poll();
                if(i != size-1) 
                    curr.next = queue.peek();
                if(curr.left != null) {
                    queue.add(curr.left);
                    queue.add(curr.right);
                }
            }
        }
        return root;
    }
}