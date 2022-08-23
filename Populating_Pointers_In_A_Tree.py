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
        queue=[root]
        
        while queue:
            l=len(queue)
            
            while l:
                p=queue.pop(0)
                if p:
                    if l-1:
                        p.next=queue[0]
                    else:
                        p.next=None
                        
                    queue.append(p.left)
                    queue.append(p.right)
                    
                l-=1
            
        return root
        