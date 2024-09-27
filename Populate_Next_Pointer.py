"""
# Definition for a Node.
class Node:
    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next
"""
#Time:O(n)
#space:O(logn)
from collections import deque

class Solution:
    def connect(self, root: 'Node') -> 'Node':
        
        
        def traverse(root):
            if not root:
                return
            
            if root.left:
                if root.right:
                    root.left.next = root.right
            if root.right:
                if root.next:
                    root.right.next = root.next.left
            traverse(root.left)
            traverse(root.right)
        traverse(root)
        return root