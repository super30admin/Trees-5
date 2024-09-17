/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
/*
method 1 : 
BFS traversal using queue.
time complexity : O(n)
space complexity: O(n)

method 2 :
without using extra space and use of 2 pointers levelptr and currptr. 
time complexity : O(n)
space complexity:O(1)

method 3: 
DFS approach 
time complexity :O(n)
recursively connect the nodes 

*/
class Solution {
    public Node connect(Node root) {
        if(root == null)return root;
        
        //method 1
//         Queue<Node> queue = new LinkedList<>();
//         queue.add(root);
        
//         while(!queue.isEmpty()){
//             int size = queue.size();
//             Node prev= queue.poll();
            
//             if(prev.left != null){
//                 queue.add(prev.left);
//                 queue.add(prev.right);
//             }
                
            
//             for(int i = 1;i < size;i++){
//                Node curr = queue.poll();
//                 if(curr.left != null){
//                      queue.add(curr.left);
//                      queue.add(curr.right);
//                 }
                   
                
//                 prev.next = curr; 
//                 prev = curr;
//             }
            
//         }
        
        //method 2
        // Node levelPtr = root;
        // while(levelPtr.left != null){
        //     Node curr = levelPtr;
        //     while(curr != null){
        //         curr.left.next = curr.right;
        //         if(curr.next != null){
        //             curr.right.next = curr.next.left;
        //         }
        //         curr = curr.next;
        //     }
        //     levelPtr = levelPtr.left;
        // } 
        dfs(root.left,root.right);
        return root;
    }
    private void dfs(Node left, Node right){
        if(left == null)return;
       
        left.next = right;
        dfs(left.left,left.right);
        dfs(left.right, right.left);
        dfs(right.left,right.right);
    }
}