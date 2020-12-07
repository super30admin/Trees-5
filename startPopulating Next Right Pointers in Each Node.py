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
    #Recursive
        def helper(node):
            
            if not node or not node.right:
                return
            node.left.next = node.right
            if node.next:
                if node.right:
                    node.right.next = node.next.left
            helper(node.left)
            helper(node.right)
        helper(root)
        return root
    
    
    #Iterative
        if not root:
            return root
        start = root
        while start.left:
            node = start
            while node:
                node.left.next = node.right
                if node.next:
                    node.right.next = node.next.left
                node = node.next
            start = start.left
        return root
            
