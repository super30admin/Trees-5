// Optimized BFS: We will not use a queue here. We will use a level and current pointer. We will set bot the pointers to the root node in the beginnning. We will keep moving the current pointer to the next node. Once the current node reaches the null node, we will move the level to the next left node. Then start the current pointer from the left most node of that level. To connect the children with the same parent, we just set the next pointer of the left child to the right. To connect the children with different parents, we just need to connect the right node of parent 1 to the left node of parent 2(which is also the next node of parent 1).
//  TC: O(n), SC: O(n)

class Solution 
{
    public Node connect(Node root) 
    {
        if(root==null) return root;
        Node level=root;
        while(level.left!=null)
        {
            //set the curr pointer to the level node
            Node curr=level;
            //Move the current pointer until the last node of the level is reached
            while(curr!=null)
            {
                //connect children with the same parents
                curr.left.next=curr.right;
                //children with different parents
                if(curr.next!=null)
                {
                    curr.right.next=curr.next.left;
                }
                //move the curr pointer
                curr=curr.next;
            }
            //move the level
            level=level.left;
            
        }
        return root;
    }
}




// BFS: We will maintain a queue to perform a BFS. We will push the nodes level by level and pop them one by one. When they are popped, we will process them by making them point to the next node, and by adding their child nodes in the queue.  TC: O(n), SC: O(n)

class Solution 
{
    public Node connect(Node root) 
    {
        if(root==null) return root;
        Queue <Node> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            //size to maintain the level
            int size=q.size();

            for(int i=0;i<size;i++)
            {
                Node curr= q.poll();
                //if it is not the last node of a level
                if(i!=size-1)
                {   
                   curr.next=q.peek();
                }
                //if there are child nodes to the curr node, then we need to add them to the queue
                if(curr.left!=null)
                {
                    q.add(curr.left);
                    q.add(curr.right);
                }
            }
        }
        return root;
    }
}

// DFS
//  TC: O(n), SC: O(h)

class Solution 
{
    public Node connect(Node root) 
    {
        if(root==null) return root;
        dfs(root);
        return root;
    }

    private void dfs(Node curr)
    {
        //base
        if(curr.left==null) return;

        //logic
        //connect children with the same parents
        curr.left.next=curr.right;
        //children with different parents
        if(curr.next!=null)
        {
            curr.right.next=curr.next.left;
        }

        dfs(curr.left);
        dfs(curr.right);
    }
}



//DFS


class Solution {
    public Node connect(Node root) {
        if (root==null) return root;
        dfs(root.left,root.right);
        return root;
    }

    private void dfs(Node left, Node right)
    {
        //base
        if(left==null) return;
        //logic
        left.next=right;
        dfs(left.left,left.right);
        dfs(left.right,right.left);
        dfs(right.left,right.right);
    }
}

