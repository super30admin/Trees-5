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
        self.helper(root.left, root.right)
        return root

    def helper(self, left, right):
        # base case
        if left == None:
            return

        # logic
        left.next = right
        self.helper(left.left, left.right)
        self.helper(left.right, right.left)
        self.helper(right.left, right.right)
