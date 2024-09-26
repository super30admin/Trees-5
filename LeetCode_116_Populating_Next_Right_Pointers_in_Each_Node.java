//approach -1 Level order traversal - BFS and Q
//tc - O(N), SC - O(N)

/*
// Definition for a Node.
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
};
*/

class Solution {
    public Node connect(Node root) {
        if(root == null) return root;
        
        Queue<Node> q = new LinkedList<>();
        
        q.add(root);
        
        //BFS
        while(!q.isEmpty())
        {
            int size = q.size();
            
            Node curr = q.poll();
            if(curr.left != null)
            {
                q.add(curr.left);
                q.add(curr.right);
            }
            
            for(int i=1; i<size; i++)
            {
                Node temp = q.poll();
                if(temp.left != null)
                {
                    q.add(temp.left);
                    q.add(temp.right);
                }
                curr.next = temp;
                curr= curr.next;
            }
        }
        return root;
    }
}

//approach-2
//DFS - pre-order kinda traversal, 
//we take care of three caeses here
//we go recursively to left's left and left's right to make connection
//we go recursively to Right's left and Right's right to make connection
//we go recursively to left's right and Right's left to make connection
//tc- O(N)
//sc - O(h) = perfect tree height is log n so O(log n)

/*
// Definition for a Node.
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
};
*/

class Solution {
    public Node connect(Node root) {
        if(root == null) return root;
       
        Node left = root.left;
        Node right = root.right;
        
        dfs(left, right);
        
        return root;
    }
    private void dfs(Node left, Node right)
    {
        if(left == null) return; // we dont have to check for right as it will be always present. 
        
        //logic
        left.next = right;
        
        dfs(left.left, left.right);
        dfs(right.left, right.right);
        dfs(left.right, right.left);
    }
}

//approach -3
//take curr and level starting at root. 
//level just helps to go down , curr just helps to make all connection
//we stop when level.left is null. 
//we check if curr is not null, then we do following
//      curr.left.next = curr.right - one connection is set
//      if curr.next != null 
//          then curr.right.next = curr.next.left; - 2nd intermediate connections we make
// then  we have to look to make changes into the right node as well, so we just update - curr = curr.next
//and rest will take care of it. 
//tc - O(N)
//sc - O(1) we dnt use anythign other than two nodes.

/*
// Definition for a Node.
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
};
*/

class Solution {
    public Node connect(Node root) {
        if(root == null) return root;
       
        Node lvl = root;
        Node curr = root;
        
        while(lvl.left != null)
        {
            curr = lvl;
            while(curr != null)
            {
                curr.left.next = curr.right;
                if(curr.next != null)
                {
                    curr.right.next = curr.next.left;
                }
                curr = curr.next;
            }
            lvl = lvl.left;
        }
        return root;
}
}