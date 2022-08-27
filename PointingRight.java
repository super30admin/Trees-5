// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes


class Solution {
    public Node connect(Node root) {
        if(root == null){
            return null;
        }
        Queue<Node> q = new LinkedList();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            Node cur = q.poll();
            if(cur.left != null){
                q.add(cur.left);
                q.add(cur.right);
            }
            for(int i=1;i<size;i++){
                Node next = q.poll();
                cur.next = next;
                if(next.left !=null){
                    q.add(next.left);
                    q.add(next.right);
                }
                cur=next;
            }
        }
        return root;
    }
}