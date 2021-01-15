// BFS Without space, Time - O(N)
class Solution {
    public Node connect(Node root) {
         if(root == null) {
            return root;
        }
        
        Node level = root;
        Node cur = level;
        while(level!=null) {    
            level = cur.left;  
            while(cur != null) {
                if(cur.left!=null) {
                    cur.left.next = cur.right;                                
                    if(cur.next!=null) {
                        cur.right.next = cur.next.left;                    
                    }
                }
                cur = cur.next;
            }
            cur = level;
        }
        
        
        return root;
        
    }

    
// DFS Recursive, Time - O(N), Space - O(H)

class Solution {
    public Node connect(Node root) {
        if(root == null) {
            return root;
        }
        
        dfs(root.left, root.right);
        
        return root;
    }
    
    private void dfs(Node left, Node right) {
        if(left == null) {
            return;
        }
        
        left.next = right;
        dfs(left.left, left.right);
        dfs(left.right, right.left);
        dfs(right.left, right.right);
    }
}

// BFS Brute Force
// Time - O(N)
// Space - O(N)

class Solution {
    public Node connect(Node root) {
         if(root == null) {
            return root;
        }
        
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0;i<size;i++) {
                Node cur = q.poll(); 
                if(i!=size-1) {
                    cur.next = q.peek();
                }
                if(cur.left!=null) {
                    q.add(cur.left);   
                }
                if(cur.right!=null) {
                    q.add(cur.right);                    
                }
            }
        }
        
        return root;
        
    }
}
