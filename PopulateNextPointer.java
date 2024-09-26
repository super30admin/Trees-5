// 116.
class Solution {
    public Node connect(Node root) {
        //edge
        if(root == null)
        {
            return null;
        }
        //return bfs1(root);
        //return bfs2(root);
        dfs(root);
        return root;
    }
    
    //time - O(n) - visit all nodes in tree
    //space - O(n) - queue size is max in last level i.e n/2
    private Node bfs1(Node root) {
        //initialize the queue and push the root as in a normal bfs
        Queue<Node> support = new LinkedList<>(); 
        support.offer(root);
        while(!support.isEmpty()) //as long as there are more elements in queue
        {
            int layerSize = support.size(); //process nodes in same layer at once
            //1st node in each layer is polled out 1st and add its children to queue(if present)
            Node prev = support.poll(); 
            if(prev.left != null)
            {
                support.offer(prev.left);
            }
            if(prev.right != null)
            {
                support.offer(prev.right);
            }
            //for the remaining nodes in current layer, poll node, add children(if present) and make next of previous point to current node and make current as previous
            for(int i = 0; i < layerSize - 1; i++)
            {
                Node current = support.poll();
                if(current.left != null)
                {
                    support.offer(current.left);
                }
                if(current.right != null)
                {
                    support.offer(current.right);
                }
                prev.next = current;
                prev = current;
            }  
        }
        return root;
    }
    
    //time - O(n) - visit all nodes
    //space - constant
    private Node bfs2(Node root) {
        //iterate through each level till the second last level
        //in each level, fix the next pointers of the children in next level
        Node temp = root; 
        while(temp.left != null)
        {
            Node current = temp;
            while(current != null)
            {
                if(current.left != null) //perfect binary tree - if left exists then right must exist
                {
                    //in the next level current's left child's next points to current's right child 
                    current.left.next = current.right; 
                }
                //if current has right child then current's next will also have children (both left and right)- perfect binary tree
                if(current.right != null && current.next != null)
                {
                    current.right.next = current.next.left;
                }
                current = current.next; //go to next node in current level
            }
            temp = temp.left; // go to next level
        }
        return root;
    }
    
    //time - O(n) - visit all nodes
    //space - O(h) - max recursive stack size is height of tree
    private void dfs(Node root) {
        //base
        if(root.left == null && root.right == null) //leaf node - don't process leaves i.e last level
        {
            return;
        }
        //logic
        if(root.left != null) //fix the next link of left child of root
        {
            root.left.next = root.right;
        }
        if(root.right != null && root.next != null) //fix the next link of right child of root
        {
            root.right.next = root.next.left;
        }
        dfs(root.left); //go to the last level
        dfs(root.right); //continue traversing
    }
}
