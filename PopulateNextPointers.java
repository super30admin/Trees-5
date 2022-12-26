public class PopulateNextPointers {
//https://leetcode.com/problems/populating-next-right-pointers-in-each-node/submissions/865010613/
    //TC - O(n)
    //SC - O(1)
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
// DFS
/*
* TC - O(n)
* SC- O(h)
* */
    /*
 public Node connect(Node root) {
        if(root == null) return root;

        dfs(root.left,root.right);

        return root;


    }
    private void dfs(Node left, Node right){
        if(left == null ) return;
        left.next = right;
        dfs(left.left,left.right);
        dfs(left.right,right.left);
        dfs(right.left,right.right);

      }




* */


//Left Right without queue
 //TC - O(n)
    //SC O(1)
public Node connect(Node root) {
        if(root == null ) return root;
        Node left = root;
        Node curr = root;
        while(left.left!=null){
            curr = left;
            while(curr!=null){
                curr.left.next= curr.right;
                if(curr.next!=null) curr.right.next = curr.next.left;
                curr= curr.next;
            }
           left= left.left;

        }
        return root;
    }




/*
* TC - O(n)
* SC - O(n)
*
    public Node connect(Node root) {
        if(root == null ) return root;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            Node curr = q.poll();
            if(curr.left!=null){
                q.add(curr.left);
                q.add(curr.right);
            }
            for(int i =0; i<size-1;i++){
                Node next = q.poll();
                curr.next = next;
                if(next.left!=null){
                    q.add(next.left);
                    q.add(next.right);
                }
                curr =next;
            }


        }
        return root;

    }*/

}
