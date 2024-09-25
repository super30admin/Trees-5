// Time Complexity: O(n)
// Space Complexity: O(max width of tree)
class Solution {
    public Node connect(Node root) {
        if(root==null) return null;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
           int size = q.size();
        Node prev = null;
            for(int i=0;i<size;i++){
                Node curr = q.poll();
                if(i!=0){
                    prev.next=curr;
                }
                if(curr.left != null){
                    q.add(curr.left);
                    q.add(curr.right);
                    
                }
                prev=curr;
            }
        }
        return root;
    }
}
