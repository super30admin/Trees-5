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
            return root
        
        q = [root]

        while q:
            size = len(q)
            for i in range(size):
                curr = q.pop(0)
                if i < size - 1:
                    curr.next = q[0]
                if curr.left:
                    q.append(curr.left)
                if curr.right:
                    q.append(curr.right)
        return root






