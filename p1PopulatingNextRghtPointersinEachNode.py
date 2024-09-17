"""
# Definition for a Node.
class Node:
    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next



time: O(N)
space: O(1), recursive stack isnt extra space as give in prob
"""

class Solution:
    def connect(self, root):
        """
        :type root: TreeLinkNode
        :rtype: nothing
        """
        
        if not root or not root.left or not root.right:
            return None
        root.left.next = root.right
        if root.next:
            root.right.next = root.next.left
            
        self.connect(root.right)
        self.connect(root.left)
        return root