// TC: O(n)
// SC: O(n)

class Solution {
    public Node connect(Node root) {
        if(root == null) {
            return null;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int size;
        while(!q.isEmpty()) {
            size = q.size();
            Node prev = q.poll();
            if(prev.left != null) {
                // we don't need to check if right is null because this is a perfect binary tree
                q.add(prev.left);
                q.add(prev.right);
            }
            for(int i = 1; i < size; i++) {
                Node curr = q.poll();
                prev.next = curr;
                if(curr.left != null) {
                    q.add(curr.left);
                    q.add(curr.right);
                }
                prev = curr;
            }
        }
        return root;
    }
}