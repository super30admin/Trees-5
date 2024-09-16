class Solution {
    public Node connect(Node root) {
        Queue<Node> q= new LinkedList<>();
         if (root == null) {
            return root;
        }
        q.add(root);
        int size;
        while(!q.isEmpty()){
            size= q.size();
            Node curr;
            for(int i=0; i< size; i++){
                curr= q.poll();
                if (i < size - 1) {
                    curr.next = q.peek();
                }
                if (curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
        }
        return root;
    }
}

//time - O(n)
//space - O(n)

//another approach

class Solution {
 
    public Node connect(Node root) {
        Node level_start=root;
        while(level_start!=null){
            Node cur=level_start;
            while(cur!=null){
                if(cur.left!=null) cur.left.next=cur.right;
                if(cur.right!=null && cur.next!=null) cur.right.next=cur.next.left;
                
                cur=cur.next;
            }
            level_start=level_start.left;
        }
        return root;
    }  
} 
//time -O(n)
//space- O(1)