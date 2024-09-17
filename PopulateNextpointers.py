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
    def connect(self, root: 'Node') -> 'Node':
        if root==None:
            return None
        level=root
        while level.left!=None:
            curr=level
            while curr!=None:
                curr.left.next=curr.right
                if curr.next:
                    curr.right.next=curr.next.left
                    
                curr=curr.next
            level=level.left
        return root
        
#Time is O(n)
#Space is O(1)
