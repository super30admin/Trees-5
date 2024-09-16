
// Time Complexity : O(N) where n is the number of nodes in the tree
// Space Complexity :O(H) where h is the height of the tree that would be stores in the stack
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach

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
      
      if(root == null)
      {
        return null;
      }
      
      Queue<Node> queue = new LinkedList<>();
      queue.add(root);
      //perform a level order traversal
      while(!queue.isEmpty())
      {
        int size = queue.size();
        //at a particular level
        for(int i=0;i<size;i++)
        {
          Node front = queue.poll();
          //from the left most node till the second last node from the right at any level 
          if( i < size - 1)
          {
            //change the next pointers
            front.next = queue.peek();
          }
          
          if(front.left != null)
          {
            queue.add(front.left);
          }
           if(front.right != null)
          {
            queue.add(front.right);
          }
        }
      }
       return root; 
    }
}


//Approach-2


// Time Complexity : O(N) where n is the number of nodes in the tree
// Space Complexity :O(1) 
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


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
      
      if(root == null)
      {
        return root;
      }
      
      Node node = root;
      //from left most node at every level
      while(node != null)
      {
        Node current = node;
        //processign at every level
        while(current != null)
        {
          if(current.left!=null)
          {
            //make the left child of any node point to the right child of that node
            current.left.next = current.right;
          }
        
          if(current.next != null && current.right != null)
          {
            //right child of the node points to the left child of the next node
            current.right.next = current.next.left;
          }
          //to go towards the right
          current = current.next;
        }
        //to go to the next level
        node = node.left;
      }
        return root;
    }
}