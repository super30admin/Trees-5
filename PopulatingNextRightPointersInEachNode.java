// Time Complexity : O(n)
// Space Complexity : O(h), h = height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Notes : Perform a BFS, while adding the elements to a queue which are at the same level, and making a link between them by peeking the top element of the queue.

public class PopulatingNextRightPointersInEachNode {
    // Solution 1 : BFS
    public Node connect(Node root) {
        if(root == null || (root.left == null && root.right == null)) return root;
        
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                Node curr = q.poll();
                if(i < size - 1){
                    curr.next = q.peek();
                }
                
                if(curr.left != null && curr.right != null){
                    q.add(curr.left);
                    q.add(curr.right);
                }
            }
        }
        
        return root;
    }

    // Solution 2 : DFS
    // List<Node> li = new ArrayList<>();
    
    // public Node connect(Node root) {
    //     if(root == null || (root.left == null && root.right == null)) return root;
        
    //     helper(root, 0);
        
    //     for(int i = 0; i < li.size(); i++){
    //         System.out.println(li.get(i).val);
    //     }
    //     return root;
    // }
    
    // private void helper(Node root, int height){
    //     if(root == null) return;
        
    //     if(li.size() < height + 1){
    //         li.add(root);
    //     } else {
    //         Node prev = li.get(height);
    //         prev.next = root;
    //         li.set(height, root);
    //     }
        
    //     helper(root.left, height+1);
    //     helper(root.right, height+1);
    // } 
}
