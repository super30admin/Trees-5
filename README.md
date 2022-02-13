# Trees-5

## Problem1 Populating Next Right Pointers in Each Node(https://leetcode.com/problems/populating-next-right-pointers-in-each-node/)

You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the 
following definition:

struct Node {

  int val;

  Node *left;

  Node *right;

  Node *next;

}
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Example:



Input: {"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":null,"right":null,"val":4},"next":null,"right":{"$id":"4","left":null,"next":null,"right":null,"val":5},"val":2},"next":null,"right":{"$id":"5","left":{"$id":"6","left":null,"next":null,"right":null,"val":6},"next":null,"right":{"$id":"7","left":null,"next":null,"right":null,"val":7},"val":3},"val":1}

Output: {"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":{"$id":"4","left":null,"next":{"$id":"5","left":null,"next":{"$id":"6","left":null,"next":null,"right":null,"val":7},"right":null,"val":6},"right":null,"val":5},"right":null,"val":4},"next":{"$id":"7","left":{"$ref":"5"},"next":null,"right":{"$ref":"6"},"val":3},"right":{"$ref":"4"},"val":2},"next":null,"right":{"$ref":"7"},"val":1}

Explanation: Given the above perfect binary tree (Figure A), your function should populate each next pointer to point to its next right 
node, just like in Figure B.

Note:

You may only use constant extra space.

Recursive approach is fine, implicit stack space does not count as extra space for this problem.

//Solutions 

//Solution 1 
class Solution {
    //Time Complexity: O(N)
    //Space Complexity: O(N)
    public Node connect(Node root) {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        
        while(!queue.isEmpty())
        {
            int size = queue.size();
            Node prev = queue.poll();
             if(prev!= null && prev.left != null)
               {
                   queue.add(prev.left);
                   queue.add(prev.right);
               }
            for(int i= 1; i<size; i++ )
            {
               Node curr = queue.poll();
                if(curr.left != null)
                {
                    queue.add(curr.left);
                    queue.add(curr.right);
                }
              prev.next = curr;
              prev = curr;
            }
        }
        
        return root;
    }
}
//Solution 2
class Solution {
    //Time Complexity: O(N)
    //Space Complexity: O(1)
    public Node connect(Node root) {
        Queue<Node> queue = new LinkedList<Node>();
        Node level = root;
        
        while(level!= null && level.left!= null )
        {
            Node curr = level;
             //process all the nodes in this list. 
            while(curr != null)
            {
                curr.left.next = curr.right;
                if(curr.next!= null)
                {
                    curr.right.next = curr.next.left;
                }
                curr = curr.next;
            }
            
            //move the curr to the next level
            level = level.left;
        }
        
        return root;
    }
}

//Soltuion 3  - DFS - uses recursive stack
class Solution {
    public Node connect(Node root) {
        if(root == null) return null;
        dfs(root.left, root.right);
        return root;
    }
    private void dfs(Node left, Node right)
    {
        if(left == null) return;
        left.next = right;
        dfs(left.left, left.right);
        dfs(left.right, right.left);
        dfs(right.left, right.right);
        
    }
}

## Problem2 Recover Binary Search Tree(https://leetcode.com/problems/recover-binary-search-tree/)

Two elements of a binary search tree (BST) are swapped by mistake.

Recover the tree without changing its structure.

Example 1:

Input: [1,3,null,null,2]


        1

      /

    3

      \

        2

Output: [3,1,null,null,2]


        3

      /

    1

      \

        2
Example 2:

Input: [3,1,4,null,null,2]


          3

        / \

      1   4

        /

      2

Output: [2,1,4,null,null,3]


        2

      / \

    1   4

       /

     3

//Solution 

class Solution {
    //Time Complexity: O(N)
    //Space Complexity: O(H), height of the tree
    TreeNode prev;
    TreeNode first;
    TreeNode second;
    private void inorder(TreeNode root)
    {
        if(root == null) return;
        inorder(root.left);
        if(prev != null && prev.val >= root.val)
        {
            if(first == null)
            {
                first= prev;
                System.out.println(first.val);
                if (second == null)
                {
                    second = root;
                    
                }
            }
            else
            {
                second = root;
                System.out.println(second.val);
            }
        }
        prev = root;
        inorder(root.right);
        
        
    }
    public void recoverTree(TreeNode root) {
        if (root == null) return;
        this.prev = null;
        this.first = null;
        this.second = null;
        inorder(root);
        //swap
        int temp_val = first.val;
        first.val = second.val;
        second.val = temp_val;
            
    }
}