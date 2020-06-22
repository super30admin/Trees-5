//time complexity O(n) since we are visiting each node
//space complexity O(n) since the max size of queue is n/2
//APPROACH BFS level order traversal

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

};
*/

class Solution {
    public Node connect(Node root) {
        if(root == null) return null;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            Node prev = q.poll();
            if(prev.left != null) q.add(prev.left);
            if(prev.right != null) q.add(prev.right);
            for(int i = 1; i < size; i++){
                Node curr = q.poll();
                prev.next = curr;
                prev = curr;
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
        }
       return root;
    }
}
