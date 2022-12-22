//TC: O(n)
//SC: O(n)

class Solution {
    public Node connect(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        if(root==null)
            return root;
        Node prev = null;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                Node curr = q.poll();
                if(i!=0){
                    prev.next = curr;
                }
                if(curr.left!=null)
                    q.add(curr.left);
                if(curr.right!=null)
                    q.add(curr.right);
                prev = curr;
            }
        }
        return root;
    }
}