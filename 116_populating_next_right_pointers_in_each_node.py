"""
# Definition for a Node.
class Node:
    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next
"""

from collections import deque


class Solution:
    def connect(self, root: 'Node') -> 'Node':
        """
            https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
            Time Complexity - O(n)
            'n' is the number of nodes
            Space Complexity - O(1)
        """
        # edge case
        if not root:
            return root

        tmp = root
        while tmp.left:
            cur = tmp
            while cur:
                cur.left.next = cur.right
                if cur.next:
                    cur.right.next = cur.next.left
                cur = cur.next
            tmp = tmp.left
        return root

    def connect(self, root: 'Node') -> 'Node':
        """
            https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
            Time Complexity - O(n)
            'n' is the number of nodes
            Space Complexity - O(n)
        """
        if not root:
            return root

        queue = deque([root])
        # level order traversal
        while queue:

            size = len(queue)

            for i in range(size):
                cur = queue.popleft()
                # This check is important. We don't want to
                # establish any wrong connections. The queue will
                # contain nodes from 2 levels at most at any
                # point in time. This check ensures we only
                # don't establish next pointers beyond the end
                # of a level
                if i < size - 1:
                    cur.next = queue[0]
                if cur.left:
                    queue.append(cur.left)
                if cur.right:
                    queue.append(cur.right)

        return root
