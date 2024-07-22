//Problem 1
//TC O(n)
//SCO(n)
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
      // bfs
      if(root==null) return root;
      Queue<Node> q=new LinkedList<>();
      q.add(root);
      while(!q.isEmpty())
      {
        int n=q.size();
        for(int i=0;i<n;i++)
        {
            Node cur=q.poll();
            if(i<n-1)
            {
                cur.next=q.peek();
            }
            if(cur.left!=null)
            {
                q.add(cur.left);
                q.add(cur.right);
            }
        }
      } 
      return root; 
    }
}
//Problem 2
//TC O(n)
//SCO(n)
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
     
   
    public List<Integer> inorderTraversal(TreeNode root) {
      Stack<TreeNode> s=new Stack<>();
      List<Integer> res= new ArrayList<>();
      while(root!=null || !s.isEmpty())
      {
        while(root!=null)
        {
            s.push(root);
            root=root.left;
        }
        root=s.pop();
        res.add(root.val);
        root=root.right;

      }
      return res;
        
    }
}

//Problem 3
//TC O(n)
//SCO(n)

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
    TreeNode prev;
    TreeNode first,second;
    public void recoverTree(TreeNode root) {
        if(root==null) return;
        inorder(root);
        int temp=first.val;
        first.val=second.val;
        second.val=temp;
    }
    // inprder
    private void inorder(TreeNode root)
    {
        if(root==null) return;
        inorder(root.left);
        if(prev!=null && prev.val>root.val)
        {
           if(first==null)
           {
             first=prev;
           }
             second=root;//why root
        }
        
        prev=root;
        inorder(root.right);
       
    }
}