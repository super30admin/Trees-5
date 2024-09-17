//APPROACH 1: BFS level order traversal
//time complexity O(n) since we are visiting each node
//space complexity O(n) since the max size of queue is n/2

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


//APPROACH 2: Without using extra space. Just manipulate the pointers while iterating over nodes.
//time complexity O(n)
//space complexity O(1)

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
        Node level = root;
        while(level.left != null){
            Node curr = level;
            while(curr != null){
                curr.left.next = curr.right;
                if(curr.next != null){
                    curr.right.next = curr.next.left;
                }
                curr = curr.next;
            }
            level = level.left;
        }
        return root;
    }
}
