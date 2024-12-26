/*
 * tc - o(n) sc - o(h)
 */
public class PopulateNextRight{
    //another dfs approch tc - O(n) sc- o(h)
    public Node connect(Node root){
        if(root == null) return null;
        dfs(root.left, root.right);
        return root;
    }

    public void dfs(Node left, Node right){
        //base 
        if(left == null){
            return;
        }

        //logic 
        left.next = right;
        dfs(left.left, left.right);
        dfs(left.right, right.left);
        dfs(right.left, right.right);
    }

    //dfs approach
    // public Node connect(Node root){
    //     if(root == null) return null;
    //     dfs(root);
    //     return root;
    // }

    // public void dfs(Node curr){
    //     //base
    //     if(curr.left == null){
    //         return;
    //     }

    //     //logic
    //     curr.left.next = curr.right;
    //     if(curr.next != null){
    //         curr.right.next = curr.next.left;
    //     }

    //     dfs(curr.left);
    //     dfs(curr.right);
    // }

    // public Node connect(Node root) {
    //     if(root == null) return null;
    //     Node level = root;
    //     while(level.left != null){
    //         Node curr = level;
    //         while(curr != null){
    //             curr.left.next = curr.right;
    //             if(curr.next != null){
    //                 curr.right.next = curr.next.left;
    //             }
    //             curr = curr.next;
    //         }
    //         level = level.left;
    //     }
    //     return root;
    // }

    //bfs approach 
    // public Node connect(Node root) {
    //     if(root == null) return null;
    //     Queue<Node> q = new LinkedList<>();
    //     q.add(root);
    //     while(!q.isEmpty()){
    //         int size = q.size();
    //         for(int i = 0; i < size; i++){
    //             Node curr = q.poll();
    //             if(i != size-1){
    //                 curr.next = q.peek();
    //             }
    //             if(curr.left != null){
    //                 q.add(curr.left);
    //                 q.add(curr.right); //since perfect bt so if left is present then right is also there
    //             }
    //         }
    //     }
    //     return root;
    // }
}