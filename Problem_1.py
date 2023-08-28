# Time Complexity: O(n)
# Space Complexity: O(h)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

"""
# Definition for a Node.
class Node(object):
    def __init__(self, val=0, left=None, right=None, next=None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next
"""

class Solution(object):
    def connect(self, root):
        """
        :type root: Node
        :rtype: Node
        """
        q = root
        while (root and root.left):
            next = root.left
            while root:
                root.left.next = root.right
                root.right.next = (root.next and root.next.left)
                root = root.next
            root = next
        return q