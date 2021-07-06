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

/**
You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:
struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
Initially, all next pointers are set to NULL.
/**
You may only use constant extra space.
Recursive approach is fine, you may assume implicit stack space does not count as extra space for this problem.
Input: root = [1,2,3,4,5,6,7]
Output: [1,#,2,3,#,4,5,6,7,#]
Explanation: Given the above perfect binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B. The serialized output is in level order as connected by the next pointers, with '#' signifying the end of each level.
 
Constraints:
The number of nodes in the given tree is less than 4096.
-1000 <= node.val <= 1000
Time complexity : O(N)
space complexity : O(N)
is worked on leetccode : YES
**/
  
 
/**


class Solution {
    List<List<Node>> levels;
    public Node connect(Node root) {
        if(root == null) {
            return null;
        }
        levels =  new ArrayList();
        Queue<Node> q = new LinkedList();
        q.add(root);
        
        while(!q.isEmpty()) {
            int size = q.size();
            List<Node> li = new ArrayList();
            while(size-->0) {
                Node polled = q.poll();
                li.add(polled);
                if(polled.left != null) {
                    q.add(polled.left);
                }
                
                if(polled.right!= null) {
                    q.add(polled.right);
                }
            }
            
            levels.add(li);
        }
        
         for(List<Node> level :  levels) {
            Node prev = level.get(0);
            for(int i = 1;i <level.size();i++) {
              prev.next = level.get(i);
             prev = level.get(i);
         }
            prev.next = null;
     }
    
        return root;
    
        
    }
    
   

  
}
**/


// More Optimized code  discuss in class 
// with constant space
// utilizing pointer idea
// connect the level below root by next pointer and then use next pointers to get the connection
// worked on Leetcode  : YES
// recursive Space : O(Depth of Tree)
// time xomplexity : O(N)
// additional space : O(1)
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
        if(root == null) return null;
        if(root.left != null) {
            root.left.next  = root.right;
        }
        
        if(root.next != null && root.right != null) {
            
            root.right.next = root.next.left;
        }
        
        connect(root.left);
        connect(root.right);
        
        return root;
        
    }
}













