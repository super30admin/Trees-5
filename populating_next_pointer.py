# Time Complexity : Add - O(n)
# Space Complexity :O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
'''
1. Use a horizontal and vertical pointer
2. When horizonal reaches to null, increment your vetical pointer to a level below
'''



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
        
        if root is None:
            return root
        
        vert = root
        while vert.left:
            horiz = vert
            while horiz:
                horiz.left.next = horiz.right
                if horiz.right and horiz.next:
                    horiz.right.next = horiz.next.left
                
                horiz = horiz.next
                
            vert = vert.left
            
        return root
        