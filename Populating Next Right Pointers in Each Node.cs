//https://leetcode.com/submissions/detail/655162770/
//Time: O(Nodes)
//Space: O(Nodes)
/*
// Definition for a Node.
public class Node {
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
}
*/

public class Solution {
    public Node Connect(Node root) {
        if(root == null) {
            return root;
        }
        
        Queue<Node> queue = new Queue<Node>();
        queue.Enqueue(root);
        root.next = null;
   
        while(queue.Count > 0) {
            int size = queue.Count;
            List<Node> list = new List<Node>();
            for(int i = 0; i < size; i++) {
                Node node = queue.Dequeue();
                Node leftNode = node.left;
                Node rightNode = node.right;
                if(leftNode !=null && rightNode != null) {
                    queue.Enqueue(node.left);
                    queue.Enqueue(node.right);
                    list.Add(leftNode);     
                    list.Add(rightNode);    
                }
            }    
                        
            for(int i = 0; i < list.Count; i++) {
                if(i == list.Count - 1) {
                    list[list.Count - 1].next = null;
                } else {
                    list[i].next = list[i+1];
                }
            }
        }
        return root;
    }
}