//Time Complexity : O(n)
//Space Complexity: O(logn)

class Solution {
    public Node connect(Node root) {
        if(root == null) return null;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                Node curr = q.poll();
                if(i!=size-1){
                    curr.next = q.peek();
                }
                if(curr.left!=null){
                    q.add(curr.left);
                    q.add(curr.right);
                }
            }
        }
        return root;
    }
}
