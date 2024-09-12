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
        level=root
        if root==None:
            return None
        while(level.left!=None):
            cur=level
            while(cur!=None):
                
                cur.left.next=cur.right
                if cur.next:
                    cur.right.next=cur.next.left
                cur=cur.next
            level=level.left
        return root
    
        #Time O(n)
        #Space O(1)
                    
        
        
        
         
