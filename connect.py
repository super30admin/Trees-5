# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
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
        def traversal(root):
            if root == None:
                return None

            if root.left and root.right:
                root.left.next = root.right

            if root.next and root.next.left and root.right:
                root.right.next = root.next.left

            traversal(root.left)
            traversal(root.right)

        traversal(root)
        return root
