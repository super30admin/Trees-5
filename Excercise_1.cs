// Time complexity Of solution is  O(N) Number od nodes worst case we will travsal all nodes 
// Space Complexity : O(1) I am not using any extra space
//

public class Solution {
    public Node Connect(Node root) {
        if(root == null) return null;
            dfs(root);
            return root;
    
    }

    public void dfs(Node level){
        if(level.left==null || level.right==null) {return ; }

        level.left.next = level.right;
        if(level.next!=null){
            level.right.next = level.next.left;
        }
        dfs(level.left);
        dfs(level.right);
    }
}

// Time complexity Of solution is  O(N) Number od nodes worst case we will travsal all nodes 
// Space Complexity : O(1) I am not using any extra space
public class Solution {
    public Node Connect(Node root) {
        if(root == null) return null;
    Node level = root;
    while(level.left!=null){
        Node curr = level;
        while(curr!=null){
            curr.left.next = curr.right;
            if(curr.next!=null){
                curr.right.next = curr.next.left;
            }
            curr = curr.next;
        }
        level = level.left;
    }

    return root;
    }
}

// Time complexity Of solution is  O(N) Number od nodes worst case we will travsal all nodes 
// Space Complexity : O(N) 
public class Solution {
    public Node Connect(Node root) {
        if (root == null) return null;
        Queue<Node> q = new Queue<Node>();
        q.Enqueue(root);
        while(q.Any()){
            int size = q.Count;
            for(int i=0;i<size;i++){
               Node n =  q.Dequeue();
               if(i == size-1){
               n.next = null;
               }else
{             n.next = q.Peek();}
               if(n.left!=null)  q.Enqueue(n.left);
               if(n.right!=null) q.Enqueue(n.right);
            }
        }
        return root;
    }
}