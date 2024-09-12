""""// Time Complexity : O(n)
// Space Complexity : O(h)- Recursive Stack Space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
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
# DFS
class Solution:
    def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
        if root == None:
            return root
        self.helper(root)
        return root

    def helper(self, root):
        # base
        if root.left == None:
            return
        # logic
        root.left.next = root.right
        if root.next != None:
            root.right.next = root.next.left

        self.helper(root.left)
        self.helper(root.right)

# DFS- Symmetric process
# class Solution:
#     def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
#         if root==None:
#             return root
#         self.helper(root.left, root.right)
#         return root

#     def helper(self, left, right):
#         #base
#         if left==None:
#             return
#         #logic
#         left.next=right

#         self.helper(left.left, left.right)
#         self.helper(left.right, right.left)
#         self.helper(right.left, right.right)

""""// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
"""
# Optimized BFS
# class Solution:
#     def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
#         if root==None:
#             return root
#         level=root
#         while level.left!=None:
#             curr=level
#             while curr!=None:
#                 curr.left.next=curr.right
#                 if curr.next!=None:
#                     curr.right.next=curr.next.left
#                 curr=curr.next
#             level=level.left
#         return root

""""// Time Complexity : O(n)
// Space Complexity : O(n/2)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
"""
# BFS
# class Solution:
#     def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
#         if root==None:
#             return root
#         q=deque()
#         q.append(root)
#         while q:
#             size=len(q)
#             prev=None
#             for i in range(size):
#                 curr=q.popleft()
#                 if i!=0:
#                     prev.next=curr

#                 if curr.left:
#                     q.append(curr.left)
#                 if curr.right:
#                     q.append(curr.right)
#                 prev=curr

#         return root

