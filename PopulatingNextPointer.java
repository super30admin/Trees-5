// Time: O(N) | Space: O(H)

class Solution {
    public Node connect(Node root) {
        if(root == null) return root;
        dfs(root);
        return root;
    }
    // since it is complete binary tree, we start making connection first between, left and right node of root,
    // then we pop the root, go to its next, connect that with our root.left..
    // keep doing this until all the nodes are apprached.
    private void dfs(Node root) {
        if(root.left == null) return;
        root.left.next = root.right;
        dfs(root.left);
        if(root.next != null) {
            root.right.next = root.next.left;
        }
        dfs(root.right);
    }
}

// Same concept as above, but in an iterative way,
// space O(1)
class Solution {
    public Node connect(Node root) {
        Node level = root;
        while(level != null && level.left != null) {
            Node curr = level;
            while(curr!=null) {
                curr.left.next = curr.right;
                if(curr.next != null) {
                    curr.right.next = curr.next.left;
                }
                curr = curr.next;
            }
            level = level.left;
        }
        return root;
    }
}
// BFS implementation
// Space: O(Width of the tree) | Time: O(N)
class Solution {
    public Node connect(Node root) {
        Queue<Node> q = new LinkedList<>();
        if(root != null)
            q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            Node prev = null;
            for(int i=0;i<size;i++) {
                Node curr = q.poll();
                if(curr != null) {
                    q.add(curr.left);
                    q.add(curr.right);
                }
                if(prev != null)
                    prev.next = curr;
                prev = curr;
            }
        }
        return root;
    }
}