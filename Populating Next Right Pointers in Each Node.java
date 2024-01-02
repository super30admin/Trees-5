// Time Complexity: O(n)
// Space Complexity: O(h)
class Solution {
    public Node connect(Node root) {
        if(root == null) return root;
        helper(root.left, root.right);
        return root;
        
    }

    private void helper(Node left, Node right){
        if(left == null) return;
        left.next = right;
        helper(left.left, left.right);
        helper(left.right, right.left);
        helper(right.left, right.right);
    }
}

// Time Complexity: O(n)
// Space Complexity: O(1)
// BFS Approach without queue
class Solution {
    public Node connect(Node root) {
        if(root == null) return root;
        Node level = root;
        while(level.left != null){
            Node curr = level;
            while(curr != null){
                curr.left.next = curr.right;
                if(curr.next != null) curr.right.next = curr.next.left;
                curr = curr.next;
            }
            level = level.left;
        }
        return root;
        
    }
}

// Time Complexity: O(n)
// Space Complexity: O(n)
// BFS Approach with queue
class Solution {
    public Node connect(Node root) {
        if(root == null) return root;
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i< size; i++){
                Node temp = q.poll();
                if(i!= size - 1) temp.next = q.peek();
                if(temp.left != null){
                    q.add(temp.left);
                    q.add(temp.right);
                }
            }
        }
        return root;
        
    }
}

// Time Complexity: O(n)
Space Complexity: O(h)
DFS Approach
class Solution {
    public Node connect(Node root) {
        if(root == null) return root;
        if(root.left != null) root.left.next = root.right;
        if(root.right != null && root.next != null) root.right.next = root.next.left; 
        connect(root.left);
        connect(root.right);
        return root;
        
    }
}