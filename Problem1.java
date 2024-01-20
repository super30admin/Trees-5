// Time Complexity : O(N) 
// Space Complexity : O(1) // assumming recursive stack space is constant
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no

class Solution {
    
    public Node connect(Node root) {
        if(root == null) return null;
       // dfs(root.left, root.right);
       bfs(root);
        return root;
    }
    //Time :O(n)
    // Space: O(n)
    private void queueSolution(Node root){
                Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            Node prev = null;
            while(size > 0){
                Node node = queue.remove();
                if(node!=null){
                if(prev!=null){
                    prev.next = node;
                }
                prev = node;
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
                }
                size--;
            }
        }
    
    }
    // Follow up solution, using DFS with constant space ( as recursive is not counting)
    // O(n)
    private void dfs(Node left , Node right){
        //base case
        if(left == null || right == null){
            return;
        }
        left.next = right;
        // There will be three recursive cases
        dfs(left.left, left.right);
        dfs(left.right, right.left);
        dfs(right.left, right.right);

    }
    // Follow up solution, using BFS with constant space
    // O(n)
    private void bfs(Node root){
        Node level , current;
        level = root;
        while(level != null){
            current  = level;
        while(current!=null){
            if(current.left != null) current.left.next = current.right;
            if(current.next !=null && current.right != null) current.right.next = current.next.left;
            current = current.next;
        }
        level = level.left;
        }
    }
}