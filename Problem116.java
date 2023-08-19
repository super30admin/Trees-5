class Problem116 {
    //TC=O(n)
    //SC=O(n)
    public Node connectBFS(Node root) {
        if(root==null)
            return null;
        Queue<Node> que=new LinkedList<>();
        que.add(root);
        while(!que.isEmpty()){
            int size=que.size();
            for(int i=0;i<size;i++){
                Node curr=que.poll();
                if(i!=size-1){
                    curr.next=que.peek();
                }
                if(curr.left!=null){
                    que.add(curr.left);
                    que.add(curr.right);
                }
            }
        }
        return root;
    }
  //TC=O(n)
  //SC=O(1)
  public Node connect(Node root) {
        if(root==null)
            return null;
        Node level=root;
        while(level.left!=null){
            Node curr=level;
            while(curr!=null){
                curr.left.next=curr.right;
                if(curr.next!=null){
                    curr.right.next=curr.next.left;
                    }
                curr=curr.next;
            }
            level=level.left;
        }
        return root;
    }
  //TC=O(n)
  //SC=O(h)
  public Node connectDFS(Node root) {
        if(root==null)
            return null;
        dfs(root);
        return root;
    }
    private void dfs(Node root){
        if(root.left==null)
            return;
        root.left.next=root.right;
        if(root.next!=null){
            root.right.next=root.next.left;
        }
        dfs(root.left);
        dfs(root.right);
    }
  //TC=O(n)
  //SC=O(h)
  public Node connectDFS1(Node root) {
        if(root==null)
            return null;
        dfs(root.left, root.right);
        return root;
    }
    private void dfs1(Node left,Node right){
        if(left==null)
            return;
        left.next=right;
        dfs1(left.left,left.right);
        dfs1(left.right,right.left);
        dfs(right.left,right.right);
    }
}
