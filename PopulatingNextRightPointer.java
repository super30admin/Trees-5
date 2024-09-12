public class PopulatingNextRightPointer {
    /*
     * Approach 1: BFS
     * 1. A level order traversal
     * 2. Keep track of the levels
     * 3. Maintain a prev and curr while iterating through each level
     * 4. if i> 0 then prev.next = curr
     * 5. set prev = curr and add left and right children to the queue
     * Time: O(n)
     * Space: O(n)
     * 
     */
    /*
     * public Node connect(Node root) {
     * if(root == null)
     * return root;
     * 
     * Queue<Node> q = new LinkedList<>();
     * q.add(root);
     * Node prev = null;
     * while(!q.isEmpty())
     * {
     * int size = q.size();
     * for(int i=0; i< size; i++)
     * {
     * Node node = q.poll();
     * //If we add right first and then left then it would become node.next=prev
     * if(i>0)
     * {
     * prev.next = node;
     * }
     * prev = node;
     * if(node.left!= null)
     * q.add(node.left);
     * if(node.right!= null)
     * q.add(node.right);
     * 
     * 
     * }
     * prev = null;
     * }
     * 
     * return root;
     * }
     */

    /*
     * Approach 2: BFS
     * Do we need a queue?
     * Queue is making sure that all nodes at a level are processed together.
     * We can directly link the nodes on the fly and it would maintain the order for
     * us
     * while(till end of linkedlist for above level):
     * to connect siblings
     * curr.left.next = curr.right
     * to link nodes from different subtrees:
     * if current has next pointer then (because last node in the level won't have
     * it):
     * curr.right.next = curr.next.left
     * move curr to next
     * Now that the level has finished then move to the next level
     * 
     * Time: O(n)
     * Space: O(1)
     */

    /*
     * public Node connect(Node root) {
     * if(root == null) return root;
     * Node level = root;
     * while(level.left!= null)
     * {
     * Node curr = level;
     * while(curr!=null)
     * {
     * curr.left.next = curr.right;
     * if(curr.next!=null)
     * {
     * curr.right.next = curr.next.left;
     * }
     * curr = curr.next;
     * }
     * level = level.left;
     * 
     * }
     * 
     * return root;
     * }
     */

    /*
     * Approach 3: DFS
     * pattern: symmertic tree
     * perform DFS on left and right subtree
     * establish a connection from left.next=right
     * basically want to form connections recursively between left.left and
     * left.right, left.right and right.left, right.left and right.right
     * Time:O(n)
     * Space: O(h)
     */

    public Node connect(Node root) {
        if (root == null)
            return root;
        // dfs1(root.left,root.right);
        dfs2(root);
        return root;
    }

    /*
     * public void dfs1(Node left, Node right)
     * {
     * if(left == null) return;
     * left.next = right;
     * dfs(left.left,left.right);
     * dfs(left.right,right.left);
     * dfs(right.left,right.right);
     * }
     */
    public void dfs2(Node root) {
        if (root.left == null)
            return;
        root.left.next = root.right;
        if (root.next != null) {
            root.right.next = root.next.left;
        }

        dfs2(root.left);
        dfs2(root.right);
    }

}
