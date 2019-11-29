// Time Complexity : O(N)
// Space Complexity : O(H) using queue, O(1) + recursion stack using recursion.
// Did this code successfully run on Leetcode : Yes.
// Any problem you faced while coding this : Nope.


// Your code here along with comments explaining your approach
class Connect {
	
	public Node connect2(Node root) {
        if(null == root){return null;}
        if(null != root.left){
            root.left.next = root.right;
            if(null != root.next){
                root.right.next = root.next.left;
            }
        }
        connect(root.left);
        connect(root.right);
    return root;
    }
	
    public Node connect1(Node root) {
        if(null == root){return null;}
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                if(i == size-1){
                    Node node = q.poll();
                    node.next = null;
                    if(null != node.left){
                        q.offer(node.left);
                    }
                    if(null != node.right){
                        q.add(node.right);
                    }
                }else{
                    Node node = q.poll();
                    node.next = q.peek();
                    if(null != node.left){
                        q.offer(node.left);
                    }
                    if(null != node.right){
                        q.add(node.right);
                    }
                }
            }
        }
    return root;
    }
}