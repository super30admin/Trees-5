// Time Complexity : O(n) where n is the number of nodes in the tree
// Space Complexity : O(n) for the queue

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

class PopulatingNextPointers {
    public Node connectUsingQueue(Node root) {
        if(root == null){
            return null;
        }

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);

        while(!queue.isEmpty()){
            int size = queue.size();

            for(int i = 0; i < size; i++){
                Node node = queue.remove();

                if(i != size-1){
                    node.next = queue.peek();
                }

                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
        }
        return root;
    }

    public Node connectIterative(Node root) {
        if(root == null){
            return null;
        }

        Node level = root;
        Node curr = null;

        while(level.left != null){
            curr = level;

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

    public Node connectDFS(Node root) {
        if(root == null){
            return null;
        }

        dfs(root);
        return root;
    }

    private void dfs(Node root){
        if(root.left == null){
            return;
        }

        root.left.next = root.right;

        if(root.next != null){
            root.right.next = root.next.left;
        }

        dfs(root.left);
        dfs(root.right);
    }
}
