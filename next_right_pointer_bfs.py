"""
Time Complexity : O(n) where n is the total number of nodes in the tree. In worst case we have to traverse all the nodes in the tree
Space Complexity : O(h) where h is the height of the tree. In worst case the stack can have at max h elements
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
"""

from collections import deque
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
        queue = deque()
        queue.append(root)
        head = root

        while queue:
            size = len(queue)
            prev = curr = None
            for i in range(size):
                root = queue.popleft()
                curr = root
                if prev != None:
                    prev.next = curr
                prev = curr

                if root.left:
                    queue.append(root.left)
                    queue.append(root.right)

        return head
