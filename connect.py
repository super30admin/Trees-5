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
    def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
        
        if not root:
            return root
        level = root
        while level.left:
            curr = level
            while curr:
                curr.left.next = curr.right
                if curr.next:
                    curr.right.next = curr.next.left
                curr = curr.next
            
            level = level.left
            
        return root
#         if not root:
#             return root
#         q = deque([root])
#         while q:
#             size = len(q)
            
#             for i in range(size):
#                 node = q.popleft()
#                 if i < size-1:
#                     node.next = q[0]
                
#                 if node.left:
#                     q.append(node.left)
                    
#                 if node.right:
#                     q.append(node.right)
        
#         return root
