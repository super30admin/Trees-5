# TIme complexity : O(n)
# Space complexity : O(h)
# Leetcode : Solved and submitted

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
        if not root:
            return None
        self.values = []
        self.helper(root.left, 0)
        self.helper(root.right, 0)
        return root
    
    def helper(self, root, depth):
        if not root:
            return
        
        if depth == len(self.values):
            self.values.append(root)
            
        self.values[depth].next = root
        self.values[depth] = root
        
        self.helper(root.left, depth+1)
        self.helper(root.right, depth+1)
