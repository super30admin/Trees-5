//DFS solution
//TC: o(n)
//Space :o(H)/logn
class Solution {
    public Node connect(Node root) {
        if(root == null )return root;
          dfs(root.left, root.right);
        return root;
    }
    private void dfs(Node left, Node right)
    {
     if(left == null)
        {
            return;
        }
        left.next = right;
        dfs(left.left, left.right); 
        dfs(left.right, right.left);
        dfs(right.left, right.right);
        
        
        
    }
}

//Optimized solution

//TC: o(n)
//Space :o(1)

class Solution {
    public Node connect(Node root) {
        if(root == null )return null;

       // curr.left.next = curr.right;
        while(level.left != null)
        {
            Node curr = level;

                while(curr != null)
                {
                   curr.left.next = curr.right;
                    if(curr.next != null)
                    {
                        curr.right.next = curr.next.left; 
                    }
                   
                   curr= curr.next;
                }   
            level = level.left;
  
        }
        return root;
        

}