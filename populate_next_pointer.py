#Time:O(n)
#space:O(logn)
from collections import deque

class Solution:
    def connect(self, root: 'Node') -> 'Node':
        
        
        def traverse(root):
            if not root:
                return
            
            if root.left:
                if root.right:
                    root.left.next = root.right
            if root.right:
                if root.next:
                    root.right.next = root.next.left
            traverse(root.left)
            traverse(root.right)
        traverse(root)
        return root