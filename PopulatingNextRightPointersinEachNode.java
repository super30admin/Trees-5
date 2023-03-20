// bfs with extra space - with queue
public class PopulatingNextRightPointersinEachNode {
    public Node connect(Node root) {
        if(root==null) return root;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            Node prev = null;
            for(int i=0;i<size;i++){
                Node curr = q.poll();
                if(i!=0){
                    prev.next = curr;
                }
                if(curr.left!=null){
                    q.add(curr.left);
                    q.add(curr.right);
                }
                prev = curr;
            }
        }
        return root;
    }
}

// TC - O(n)
// SC - O(n)

// bfs without extra space - without queue
public class PopulatingNextRightPointersinEachNode {
    public Node connect(Node root) {
        if(root==null) return root;
        Node level = root;
        while(level.left!=null){
            Node curr = level;
            while(curr!=null){
                curr.left.next = curr.right;
                if(curr.next!=null){
                    curr.right.next = curr.next.left;
                }
                curr = curr.next;
            }
            level = level.left;
        }
        return root;
    }
}

// TC - O(n)
// SC - O(1)


// dfs 
public class PopulatingNextRightPointersinEachNode {
    public Node connect(Node root) {
        if(root==null) return root;
        helper(root.left,root.right);
        return root;
    }
    private void helper(Node left, Node right){
        // base
        if(left==null) return;

        // logic
        left.next = right;
        helper(left.left,left.right);
        helper(left.right,right.left);
        helper(right.left,right.right);
    }
}

// TC - O(n)
// SC - O(h)

// dfs 
public class PopulatingNextRightPointersinEachNode {
    public Node connect(Node root) {
        if(root==null) return root;
        helper(root);
        return root;
    }
    private void helper(Node root){
        // base
        if(root.left==null) return;

        // logic
        root.left.next = root.right;
        if(root.next!=null){
            root.right.next = root.next.left;
        }
        helper(root.left);
        helper(root.right);
    }
}

// TC - O(n)
// SC - O(h)