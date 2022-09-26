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
    def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
        if root is None:
            return None
        q = deque()
        q.append(root)
        while q:
            size = len(q)
            curr = q.popleft()
            # print(size)
            if curr.left != None:
                q.append(curr.left)
                # print(len(q))
            if curr.right != None:
                q.append(curr.right)

            for i in range(1, size):
                temp = q.popleft()
                # print(temp.val)
                curr.next = temp
                curr = temp
                # print(curr.val)
                if curr.left != None:
                    q.append(curr.left)
                if curr.right is not None:
                    q.append(curr.right)
        return root
# BFS
# Time Complexity = O(n)
# Space complexity : O(n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No