class PopulateNextPointer {
  /**
    DFS
    
    Time complexity: O(n)
    Space complexity: O(logn)
       -> Space taken by the recursive stack
    
    */
    public Node connect(Node root){
      populate(root);
      
      return root;
  }
  
  private void populate(Node curr){
      // base case
      if(curr == null || curr.left == null) { return; }
      
      // recursion
      curr.left.next = curr.right;
      populate(curr.left);
      
      if(curr.next != null)
          curr.right.next = curr.next.left;
      populate(curr.right);
  }
  
  /**
  BFS without Space

  Time Complexity: O(n)
  Space complexity: O(1)

  Were you able to solve this on leetcode? Yes
  */
  
  public Node connect(Node root){
    
      Node level = root;
      Node curr = root;
      while(level != null && level.left != null){
          curr.left.next = curr.right;
        
          if(curr.next != null){
              curr.right.next = curr.next.left;
          }
        
          curr = curr.next;
        
          if(curr == null){
              level = level.left;
              curr = level;
          }
      }
    
      return root;
  }
  
  
  /**
  Time Complexity: O(n)
  
  Space complexity: O(n)
  
  Were you able to solve this on leetcode? Yes
  */
  public Node connect(Node root) {
      Queue<Node> queue = new LinkedList<>();
      if(root == null) { return null; }
    
      queue.add(root);
      while(!queue.isEmpty()){
          int size = queue.size();
        
          for(int i = 0; i < size; i++){
              Node curr = queue.remove();
              if(i != size - 1){
                  curr.next = queue.peek();
              }
            
              if(curr.left != null){
                  queue.add(curr.left);
              }
            
              if(curr.right != null) queue.add(curr.right);
          }
      }

      return root;
  }
}