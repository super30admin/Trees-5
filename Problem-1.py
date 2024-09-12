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
        
        q=[]
        q.append(root)
        while q:
            size=len(q)
            prev=None
            while size>0:
                popped=q.pop(0)
                if prev:
                    prev.next=popped
                prev=popped  
                
                if popped.left:
                    q.append(popped.left)
                if popped.right:
                    q.append(popped.right)
                size-=1
        
        return root
        