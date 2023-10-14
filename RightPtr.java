/**
    Time Complexity - O(n) where n is the number of nodes in the tree.
    Space Complexity - O(n) (the maximum size of the queue is the last level of the tree i.e leaves. 
    Number of leaves in a binary tree will be atmost n / 2. Therefore space complexity is O(n/2) which is O(n).)
 */

class Solution {
    public Node connect(Node root) {
        
        if(root == null || (root.left == null && root.right == null))
            return root;
        
        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            int size = queue.size();
            Node prev = null;
            for(int i = 0; i < size; i++) {
                Node cur = queue.poll();
                if(i != 0)
                    prev.next = cur;
                if(cur.left != null) 
                    queue.offer(cur.left);
                if(cur.right != null)
                    queue.offer(cur.right);
                prev = cur;
            }
        }

        return root;
    }
}
