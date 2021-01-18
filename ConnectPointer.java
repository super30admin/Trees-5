/* Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL
* TC O(N). SC O(N)
/
/* dfs solution*/
class Solution {
    public Node connect(Node root) {
        if (root == null) {
               return root;
        }
        dfs(root.left, root.right);
        return root;    
    }
    private void dfs(Node left, Node right) {
        if (left == null) {
            return;
        }
        left.next = right;
        dfs(left.left, left.right);
        dfs(left.right, right.left);
        dfs(right.left, right.right);
    }
}
/* level order 
TC O(N) SC O(N) */
class Solution {
    public Node connect(Node root) {
        if (root == null)
            return null;
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        while(!q.isEmpty()) {
             int size = q.size();
            for(int i = 0; i < size; i++) {
                Node curr = q.poll();
                if (i != size -1) {
                    curr.next = q.peek();
                }
                if (curr.left != null) {
                    q.add(curr.left);
                    q.add(curr.right);
                }
            }
        }
       return root;
    }
}
/** level order without queue*/
/* TC O(N) SC O(1) */
class Solution {
    public Node connect(Node root) {
        if (root == null) {
               return null;
        }
        Node level = root;
        while(level.left != null) {
            Node curr = level;
            while(curr != null) {
                curr.left.next = curr.right;
                if (curr.next != null) {
                    curr.right.next = curr.next.left;
                }
                curr = curr.next;
            }
            level = level.left;
        }
        return root;    
    }
}
