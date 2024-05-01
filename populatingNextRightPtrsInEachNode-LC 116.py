# BFS without using q
# Time Complexity = O(n)
# Space Complexity = O(1)

"""
# Definition for a Node.
class Node:
    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next
"""

class Solution:
    def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
        if root == None: 
            return None
        
        lvl = root
        curr = None
        
        while lvl.left != None:
            curr = lvl
            while curr != None:
                curr.left.next = curr.right
                if curr.next != None:
                    curr.right.next = curr.next.left
                curr = curr.next
            lvl = lvl.left
            
        return root
   
    
# DFS without using q
# Time Complexity = O(n)
# Space Complexity = O(h), recursive stack

"""
# Definition for a Node.
class Node:
    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next
"""

class Solution:
    def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
        if root == None: 
            return None
        
        self.dfs(root.left, root.right)
        
        return root
    
    def dfs(self, left, right):
        # Base Case
        if left == None:
            return
        
        # Logic
        left.next = right
        self.dfs(left.left, left.right)
        self.dfs(left.right, right.left)
        self.dfs(right.left, right.right)
        
        
                