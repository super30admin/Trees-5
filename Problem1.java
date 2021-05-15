//Populating Next Right Pointers in Each Node
class Problem1{
    public static void main(String[] args){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        Problem1 p = new Problem1();
        p.connect(root);

    }
    Node leftNode = null;
    public Node connect(Node root) {
        if(root == null){
            return null;
        }
        dfs(root);
        return root;
    }
    private void dfs(Node root){
        if(root == null){
            return;
        }
        leftNode = root.left;
        while(root != null){
            if(root.left != null){
                root.left.next = root.right;
            }
            if(root.next != null && root.right != null){
                root.right.next = root.next.left;
            }
            root = root.next;
        }
        dfs(leftNode);


    }
}