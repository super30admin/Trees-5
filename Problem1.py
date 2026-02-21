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
        if not root: return None
        q = deque()
        q.append(root)

        while q:
            l = len(q)
            first = q.popleft()
            if first.left: q.append(first.left)
            if first.right: q.append(first.right)
            second = None
            if l == 1: 
                first.next = second
                continue
            i=1
            while i < l:
                second = q.popleft()
                if second.left: q.append(second.left)
                if second.right: q.append(second.right)
                first.next = second
                first = second
                i+=1
        
        return root



             
