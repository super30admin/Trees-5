"""
Problem2 Populating Next Right Pointers in Each Node(https://leetcode.com/problems/populating-next-right-pointers-in-each-node/)

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

"""
"""
# Definition for a Node.
class Node:
    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next
"""
import collections
class Solution:
    def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
        """
        BFS implementation using a queue. 
        Time Complexity: O(N)
        Space Complexity: O(N)
        """
        if root is None: return None
        q = deque()
        q.append(root)
        prev = None
        
        while q:
            _size = len(q)
            
            for i in range(_size):
                curr = q.popleft()
                if i != 0:
                    prev.next = curr
            
                if curr.left:
                    q.append(curr.left)
                if curr.right:
                    q.append(curr.right)
                
                prev = curr
                
        return root
                
                
# Approach - 2

import collections
class Solution:
    def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
        """
        Going level by level without using a queue. 
        Time Complexity: O(N)
        Space Complexity: O(1)
        """
        if root == None : return None
        level = root
        while level.left is not None:
            curr = level
            while curr is not None:
                curr.left.next = curr.right
                if curr.next:
                    curr.right.next = curr.next.left
                    
                curr = curr.next
                
            level = level.left
            
        return root
                
        
# Approach - 3

import collections
class Solution:
    def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
        """
        DFS,  
        Time Complexity: O(N)
        Space Complexity: O(H)
        """
        if root == None: return None
        
        def helper_dfs(left, right):
            # Base Case
            if (left == None): return 
            
            left.next = right
            
            # Logic
            helper_dfs(left.left, left.right)
            helper_dfs(left.right, right.left)
            helper_dfs(right.left, right.right)
            
        helper_dfs(root.left, root.right)
        
        return root
            
# Approach - 4

import collections
class Solution:
    def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
        """
        DFS,  
        Time Complexity: O(N)
        Space Complexity: O(H)
        """
        if root == None: return None
        
        def helper_dfs(root):
            # Base Case
            if (root.left == None): return 
            
            # Logic
            root.left.next = root.right
            if root.next is not None:
                root.right.next = root.next.left
                
            helper_dfs(root.left)
            helper_dfs(root.right)
           
            
        helper_dfs(root)
        
        return root
            
        
       
        
        
        
       
        
        
            
        
        