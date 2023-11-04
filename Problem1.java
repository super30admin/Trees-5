//TimeComplexity - O(N)
//SpaceComplexity -O(N)
// Passed all Test cases on Leetcode : Yes
// Any issues faced while executing the code : No
import java.util.LinkedList;
import java.util.Queue;

public class Problem1 {
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
    }
    public Node connect(Node root) {
        if(root == null){
            return root;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(! q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                Node curr = q.poll();
                if(i < size-1){
                    curr.next = q.peek();
                }
                if(curr.left != null){
                    q.add(curr.left);
                    q.add(curr.right);
                }

            }
        }
        return root;
    }
}
