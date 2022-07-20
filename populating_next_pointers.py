# Time Complexity : O(n)
# Space Complexity : O(1).
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
#
#

# optimized BFS
class Node:
    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next


class Solution:
    def connect(self, root):
        if not root:
            return
        level = root
        curr = root
        while level.left:
            while curr:
                curr.left.next = curr.right
                if curr.next:
                    curr.right.next = curr.next.left
                curr = curr.next
            curr = level.left
            level = level.left
        return root

# DFS
# TC: O(n); O(h)
# class Solution:
#     def helper(self, root):
#         # base
#         if root.left is None or root.right is None:
#             return
#         # logic
#         root.left.next = root.right
#         if root.next:
#             root.right.next = root.next.left
#         self.helper(root.left)
#         self.helper(root.right)
#
#     def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
#         if not root:
#             return
#         self.helper(root)
#         return root

# DFS
# TC: O(n); O(h)
# class Solution:
#     def helper(self, left, right):
#         # base
#         if left is None or right is None:
#             return
#         # logic
#         left.next = right
#         self.helper(left.left, left.right)
#         self.helper(left.right, right.left)
#         self.helper(right.left, right.right)
#
#     def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
#         if not root:
#             return
#         self.helper(root.left, root.right)
#         return root


# BFS
# from collections import deque


# class Solution:
#     def connect(self, root):
#         if not root:
#             return
#         queue = deque()
#         queue.append(root)
#         while queue:
#             prev = None
#             size = len(queue)
#             for i in range(size):
#                 curr = queue.popleft()
#                 if prev:
#                     prev.next = curr
#                 if curr.left:
#                     queue.append(curr.left)
#                 if curr.right:
#                     queue.append(curr.right)
#                 prev = curr
#             curr.next = None
#         return root

