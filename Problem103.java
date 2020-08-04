Executed in leetcode-Yes
Time && Space Complexity-o(n)

class Solution {
    public Node connect(Node root) {
        Queue<Node> q= new LinkedList<Node>();
        q.add(root);
        while(!q.isEmpty()){
         Node stNode= q.poll();
         Node tmpNode= stNode;
          while(!q.isEmpty() && stNode!=null){
            tmpNode.next=q.poll();
            tmpNode =tmpNode.next;
          }
          while(stNode!=null){
              q.add(stNode.left);
              q.add(stNode.right);
              stNode =stNode.next;
          }
        }
        return root;
    }
}
