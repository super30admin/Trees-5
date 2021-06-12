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

    public Node getSampleNode() {
        Node root = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        
        return root;
    }

    public Node getSampleNodeTwo() {
        Node root = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5); 
        root.left = node2;
        root.right = node3;
        node2.left = node4; 
        node3.right = node5; 
        
        return root;
    }

    public Node getSampleNodeThree() {
        Node root = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5); 
        Node node6 = new Node(6); 
        Node node7 = new Node(7); 
        Node node8 = new Node(8); 
        root.left = node2;
        root.right = node3;
        node2.left = node4; 
        node2.right = node5; 
        node3.right = node6; 
        node4.left = node7; 
        node6.right = node8; 
        return root;
    }
};