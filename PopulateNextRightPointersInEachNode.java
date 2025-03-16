public class PopulateNextRightPointersInEachNode {
    public Node connect(Node node) {
        if(node==null) return node;

        Node leftmostNode=node;

        while(leftmostNode.left!=null){
            Node head = leftmostNode;
            while(head!=null){
                //case 1
                head.left.next=head.right;

                //case 2
                if(head.next!=null)
                    head.right.next=head.next.left;

                head=head.next;
            }

            leftmostNode=leftmostNode.left;

        }

        return node;
    }
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

}

//level-order-traversal TC-O(N) SC-O(N)
/*
  public Node connect(Node node) {
        if(node==null) return node;
        Queue<Node> q=new LinkedList<Node>();
       q.add(node);
       while(q.size()>0){
        int size=q.size();
        System.out.println(size);
        for(int i=0;i<size;i++){
         Node curr=q.poll();
          if(i<size-1){ //peek should not happen to the next level elements that got added to the q
            System.out.println("--"+size);
            curr.next=q.peek();
           }
            if (curr.left != null) {
                    q.add(curr.left);
                }
            if (curr.right != null) {
                    q.add(curr.right);
                }

        }

       }

return node;

    }
* */
