"""
Time Complexity : O(n) where n is the total number of nodes in the tree. In worst case we have to traverse all the nodes in the tree
Space Complexity : O(h) where h is the height of the tree 
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
"""

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
            return root
        self.helper(root)
        return root

    def helper(self, root):
        # base case
        if root.left == None:
            return

        # logic
        root.left.next = root.right
        if root.next:
            root.right.next = root.next.left
        self.helper(root.left)
        self.helper(root.right)
