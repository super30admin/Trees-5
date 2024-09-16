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


from typing import Optional

from yaml import Node


class Solution:
    def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
        if not root:
            return root

        # no next pointers on the first level so left is root
        leftmost = root

        # run a loop till we reach the final level
        while leftmost.left:

            # iterate starting from the head node and using the next pointers
            curr = leftmost

            while curr:

                # CONNECTION 1
                curr.left.next = curr.right

                # CONNECTION 2
                if curr.next:
                    curr.right.next = curr.next.left

                # check for the nodes on the current level
                curr = curr.next

            # increment the level
            leftmost = leftmost.left

        return root
