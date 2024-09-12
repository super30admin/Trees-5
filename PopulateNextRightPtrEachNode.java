// Time Complexity: O(n)
// Space Complexity: O(1)
// iterative
public class PopulateNextRightPtrEachNode {
    public Node connect(Node root) {
        if(root == null)
            return null;
        Node curr = root, level = root;

        while(level.left != null) // till last row of BT and using adv of complete BT use only left
        {
            // check all nodes at current level and connect their kids
            while(curr != null)
            {
                curr.left.next = curr.right;
                if(curr.next != null) // has a neigh
                {
                    curr.right.next = curr.next.left;
                }
                // move to neigh
                curr = curr.next;
            }
            // all elements of level connected go to next level
            level = level.left;
            curr = level; // first element of every level
        }

        return root;
    }
}

// Time Complexity: O(n)
// Space Complexity: O(h) where h is height of the tree
// DFS
public class PopulateNextRightPtrEachNode {
    public Node connect(Node root) {
        if(root == null || root.left == null || root.right == null) // no child to connect
            return root;
       
        root.left.next = root.right; // connect children
        if(root.next != null) // has neigh
        {
            root.right.next = root.next.left;
        }
        
        // go to next level
        connect(root.left);
        // go to neigh at same level i.e of root
        connect(root.right);
        
        return root;
    }
}

public class PopulateNextRightPtrEachNode {
    public Node connect(Node root) {
        if(root == null)
            return root;
        helper(root.left, root.right);    
        return root;
    }
    private void helper(Node left, Node right)
    {
        // base
        if(left != null && right != null)
            return;
        
        // logic
        left.next = right; // connect children 
        
        helper(left.left, left.right);
        helper(left.right, right.left);
        helper(right.left, right.right);
    }
}

// Time Complexity: O(n)
// Space Complexity: O(h) where h is height of the tree
// BFS
public class PopulateNextRightPtrEachNode {
    public Node connect(Node root) {
        if(root == null)
            return null;
        
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        
        //level order traversal
        while(!q.isEmpty())
        {
            int size = q.size();
            Node curr = null, prev = null;
            for(int i = 0 ; i < size; i ++)
            {
                curr = q.poll();
                if(curr.left != null) // do not check right as it is a complete BT
                {
                    q.offer(curr.left);
                    q.offer(curr.right);
                }
                // avoids first node in every level
                if(prev != null)
                {
                    prev.next = curr;
                }
                prev = curr;
            }
        }
        return root;
    }
}
