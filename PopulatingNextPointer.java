// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach -
class Solution {
    public Node connect(Node root) {
        if(root==null) return root;
        Node lvl = root;
        Node cur = null;

        while(lvl.left!=null){
            cur = lvl;
            while(cur!=null){
                cur.left.next = cur.right;
                if(cur.next!=null){
                    cur.right.next = cur.next.left;
                }
                cur = cur.next;
            }
            lvl = lvl.left;
        }
        return root;
    }
}

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach - BFS
class Solution {
    public Node connect(Node root) {
        if(root==null) return root;
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();
            for(int i=1; i<=size; i++){
                Node cur = q.poll();

                if(cur.left!=null && cur.right!=null) {
                    q.add(cur.left);
                    q.add(cur.right);
                }

                if(i<=size-1){
                    cur.next = q.peek();
                }
            }
        }
        return root;
    }
}

// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach - DFS
class Solution {
    public Node connect(Node root) {
        if(root==null) return root;
        dfs(root);
        return root;
    }
    public void dfs(Node root){
        if(root.left==null) return;

        root.left.next = root.right;
        if(root.next!=null){
            root.right.next = root.next.left;
        }

        dfs(root.left);
        dfs(root.right);
    }
}

// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach - DFS passing both
// left and right pointers in the recursive function calls
class Solution {
    public Node connect(Node root) {
        if(root==null || root.left==null) return root;
        dfs(root.left, root.right);
        return root;
    }
    public void dfs(Node left, Node right){
        if(left==null) return;

        left.next = right;
        dfs(left.left, left.right);
        dfs(left.right, right.left);
        dfs(right.left, right.right);
    }
}