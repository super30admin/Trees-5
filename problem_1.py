# BFS
# TC - O(N)
# SC - O(N)

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
        q = []
        q.append(root)
        while q :
            size = len(q)
            for i in range(size):
                curr = q.pop(0)
                if i < size-1 :
                    curr.next = q[0]
                if curr.left:
                    q.append(curr.left)
                    q.append(curr.right)
        return root


# Optimized BFS
# TC - O(N)
# SC - O(1)
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
        level = root
     
        while level.left :
            curr = level 
            while curr:
                curr.left.next = curr.right
                if curr.next:
                    curr.right.next = curr.next.left 
                curr = curr.next 
            level = level.left
          
        return root
        
        