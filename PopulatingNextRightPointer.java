//DFS - 1 (extra space)
//Time Complexity: O(n)
//Space Complexity: O(n) leaves of binary tree

/*
 * we store each element in a queue and we iterater through the queue.
 * and pointing next to the next element. adding the left and right 
 * pointers to the queue and return root.
 */

class Solution {
    public Node connect(Node root) {
        if(root == null) return root;
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                Node curr = q.poll();
                if(i != size - 1) curr.next = q.peek();
                if(curr.left != null){
                    q.add(curr.left);
                    q.add(curr.right);
                }
            }
        }
        return root;
    }
}

//DFS - 2 (no extra space)
//Time Complexity: O(n)
//Space Complexity: O(1)

/*
 * maintain a level and current pointer. when we travese though
 * the nodes we mark left to right of current node and right to left of 
 * the next node. and increment the pointer.
*/
class Solution {
    public Node connect(Node root) {
        if(root == null) return root;

        Node level = root;
        while(level.left != null){
            Node curr = level;
            while(curr != null){
            curr.left.next = curr.right;
            if(curr.next != null) curr.right.next = curr.next.left;
            curr = curr.next;
            }
            level = level.left;
        }
        return root;
    }
}

//DFS - 1
//Time Complexity: O(n)
//Space Complexity: O(h) // recursive stack space

/*
 * maintain left and right pointers and call the recursive function
 * for all the nodes we want to make connections for. and if the 
 * node is null we return.
*/

class Solution {
    public Node connect(Node root) {
        if(root == null) return root;
        Node Left = root.left;
        Node Right = root.right;
        dfs(root, Left, Right);
        return root;
    }

    public void dfs(Node root, Node Left, Node Right){
        //base
        if(Left == null) return;

        //logic
        Left.next = Right;
        dfs(root, Left.left, Left.right);
        dfs(root, Left.right, Right.left);
        dfs(root, Right.left, Right.right);
    }
}

//DFS - 2 (same logic as BFS - 2 with recursion)
//Time Complexity: O(n)
//Space Complexity: O(h) // recursive stack space

/*
 * make the connection between left and right of same node and if 
 * there is next then betwwen right and next's left. Then call the 
 * recursion for left and right of the root. if the left is empty return null.
*/

class Solution {
    public Node connect(Node root) {
        if(root == null) return root;
        dfs(root);
        return root;
    }

    public void dfs(Node root){
        //logic
        if(root.left == null) return;

        //base
        root.left.next = root.right;
        if(root.next != null) root.right.next = root.next.left;
        dfs(root.left);
        dfs(root.right);
    }
}