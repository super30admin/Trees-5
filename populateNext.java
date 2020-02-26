// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//recursive solution
class Solution {
    public Node connect(Node root) {
        if(root == null){
            return root;
        }
        dfs(root.left, root.right);
        
        return root;
    }
    
    private void dfs(Node left, Node right){
        //base case
        if(left == null){
            return;
        }
        //logic
        
        left.next = right;
        dfs(left.left, left.right);
        dfs(left.right, right.left);
        dfs(right.left, right.right);
    }
}


// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


//iterative solution
class Solution {
    public Node connect(Node root) {
        if(root == null){
            return root;
        }
        
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                Node temp = q.poll();
                if(temp.left != null){
                    q.add(temp.left);
                    q.add(temp.right);
                }
                
                if(i < size - 1){
                    Node nextNode = q.peek();
                    temp.next = nextNode;
                }
            }
        }
        return root;
    }
    
}
