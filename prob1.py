# Time Complexity :O(n)
# Space Complexity :O(h)
# Leet Code: Yes

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
        self.inorderTraversal(root)
        return root
    
    def inorderTraversal(self, root):
        if root is None or root.left is None:
            return
        
        #logic
        root.left.next = root.right
        if root.next is not None:
            root.right.next = root.next.left
        
        self.inorderTraversal(root.left)
        self.inorderTraversal(root.right)
        
