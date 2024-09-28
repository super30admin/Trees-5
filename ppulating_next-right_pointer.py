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
        def pointer(root):
            
            if root is None:
                return
            print(root.val)
            if root.left and root.right:
                root.left.next = root.right
            
            if root.next:
                rl_most = root.next.left if root.next.left else root.next.right
                if root.right:
                    root.right.next = rl_most
                elif root.left:
                    root.left.next = rl_most
                
            
                
            pointer(root.left)
            pointer(root.right)
            
            return
        pointer(root)
        return root
            
            
        