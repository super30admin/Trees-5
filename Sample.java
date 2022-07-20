//****RECOVER BINARY SEARCH TREE****
//Time complexity: 0(n);
//Space complexity:0(H); recursive stack space;
//Leetcode runnable: Y;
//

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    TreeNode first;
    TreeNode second;
    TreeNode prev;
    public void recoverTree(TreeNode root) {
        //null case
        if(root==null)
        {
            return ;
        }
        
        inorder(root);
        int temp=first.val;
        first.val=second.val;
        second.val=temp;
    }
    
    public void inorder(TreeNode root)
    {
        //Base case
        if(root==null)
        {
            return;
        }
        //Logic
        inorder(root.left);
        //Breach
        if(prev==null || prev.val>=root.val)
        {
            //First breach
            if(first==null)
            {
                first=prev;
                second=root;
                
            }
            else
            {
                second=root;
            }
        }
        prev=root;
        
        
        inorder(root.right);
    }
}

//****104.116. POPULATING NEXT RIGHT POINTERS IN EACH NODE-  BRUTEFORCE BFS****
//Time complexity:0(n);
//Space Complexity:0(n); 
//Leetcode runnable:Y
//Any doubts:N;

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
        //null case
        if(root==null)
        {
            return null;
        }
        
        //Making queue for performing bfs
        Queue<Node> q=new LinkedList<>();
        
        //Adding root to the queue
        q.add(root);
        
        //Playing with queue
        while(!q.isEmpty())
        {
            int size=q.size();
            //Initialize a prev
            Node prev=null;
            //Iterating through queue
            for(int i=0;i<size;i++)
            {
                Node curr=q.poll();
                if(i!=0)
                {
                    prev.next=curr;
                }
                if(curr.left!=null)
                {
                    q.add(curr.left);
                    q.add(curr.right);
                }
                prev=curr;
            }
        }
        return root;
        
        
    }
}


//****104.116. POPULATING NEXT RIGHT POINTERS IN EACH NODE-  OPTIMIZED BFS****
//Time complexity:0(n);
//Space Complexity:0(1); 
//Leetcode runnable:Y
//Any doubts:N;

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
        //null case
        if(root==null)
        {
            return null;
        }
        
        Node level=root;
        
        while(level.left!=null)
        {
            Node curr=level;
            while(curr!=null)
            {
                curr.left.next=curr.right;
                if(curr.next!=null)
                {
                    curr.right.next=curr.next.left;
                }
                curr=curr.next;
            }
            level=level.left;
        }
        return root;
        
        
    }
}
