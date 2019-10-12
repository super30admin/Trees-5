//Time Complexity : O(N)
//Space Complexity : O(N)
// We will traverse the tree using BFS (Breadth First Search) and we will check if the size of the queue and the iterator value matches that means it is the last element which will point to null else we will make it point tp th enext element present in the queue using peek() function .

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
class Solution {
    public Node connect(Node root) {
        if(root == null){
            return root ;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i =0;i<size;i++){
                Node temp =queue.poll();
                if( i== size-1){
                    temp.next= null;
                }
                else{
                    temp.next = queue.peek();
                }

                if(temp.left != null){
                    queue.add(temp.left);
                }

                if(temp.right != null){
                    queue.add(temp.right);
                }
            }
        }

        return root;

    }
}