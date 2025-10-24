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
- Approach 1: BFS: Maintain a queue and the size of the queue to do level order traversal.
- To create a new link, you need to point the next pointer of the node to top element in queue except for the last element
- TC: O(n) -> iterate over all the nodes
- SC: O(n) -> queue to maintain all the nodes per level. max is n/2 number of leaf nodes but constant dont matter so its n
 */
class Solution {
    public Node connect(Node root) {
        Queue<Node> q = new LinkedList<>();
        if(root == null)
            return root;
        
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                Node curr = q.poll();

                //establish the link
                if(i < size-1){
                    curr.next = q.peek();
                }
                
                if(curr.left != null)
                    q.add(curr.left);
                if(curr.right != null)
                    q.add(curr.right);
            }
        }
        return root;
    }
}


/*
 * * Approach2: 
    - We start from root and iterate to the left child
    - point left's next to roots right for same parent
    - if the parents are diff, then lefts nexts should point to roots rights left child
TC: O(n) -> iterate through all th enodes
SC: O(1) -> no additional space required 
 */
class Solution {
    public Node connect(Node root) {
        if(root == null)
            return root;
        
        Node leftmost = root;

        while(leftmost.left != null){
            Node currHead = leftmost;

            while(currHead != null){
                // connection1 on next level with same parent
                currHead.left.next = currHead.right;
                
                //connection2 on next level with different parent
                if(currHead.next != null){
                    currHead.right.next = currHead.next.left;
                }

                currHead = currHead.next;
            }
            leftmost = leftmost.left;
        }
        return root;
    }
}