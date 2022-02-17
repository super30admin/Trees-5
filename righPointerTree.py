# TimeComplexity o(N)
# Space Complexity o(1)
# Iterate through the tree by using each level as a linked list and level pointer

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
        
        
        
        
        if root == None:
            return None
        if root.left == None and root.right == None:
            root.next == None
            return root
        
        level = root
        
        while(level.left != None):
            
            curr = level
            while(curr != None):
                curr.left.next = curr.right
                if curr.next != None:
                    curr.right.next = curr.next.left
                
                curr = curr.next
            level = level.left
        
        return root
                
            
            
        
        
            
                
                
            
            
        