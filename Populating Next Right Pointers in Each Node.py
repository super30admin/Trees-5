"""
# Definition for a Node.
class Node:
    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next
"""

from collections import deque

class Solution:
    def connect(self, root: 'Node') -> 'Node':
        #Approach: BFS Level-order Traversal
        #Time Complexity: O(n)
        #Space Complexity: O(n)
        #where, n is the size of the Binary Tree
        
        if not root:
            return None
        
        de = deque()
        de.append(root)
        
        while de:
            sz = len(de)
            prev = None
            for i in range(sz):
                popped = de.popleft()
                if prev:
                    prev.next = popped
                
                if popped.left:
                    de.append(popped.left)
                if popped.right:
                    de.append(popped.right)
                    
                prev = popped
                    
        return root