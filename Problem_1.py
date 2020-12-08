"""
Time Complexity : O(n)- for BFS without queue, for DFS as well
Space Complexity : O(1) - for BFS without queue(but) O(h) for DFS
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No


Your code here along with comments explaining your approach:
I have a BFS as well as a DFS and a preorder kind of a solution for this. In BFS, at each level, we keep
on setting the next pointer.
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
    def connect(self, root: 'Node') -> 'Node':
        if not root:
            return
        level = root
        while level.left:
            curr = level
            while curr:
                curr.left.next = curr.right
                if curr.next:
                    curr.right.next = curr.next.left
                curr = curr.next
            level = level.left
        return root


# class Solution:
#     def connect(self, root: 'Node') -> 'Node':
#         if not root:
#             return
#         self.dfs(root.left,root.right)
#         return root

#     def dfs(self,left,right):
#         if not left:
#             return
#         left.next=right
#         self.dfs(left.left,left.right)
#         self.dfs(left.right,right.left)
#         self.dfs(right.left,right.right)


# class Solution:
#     def connect(self, root: 'Node') -> 'Node':
#         if not root:
#             return
#         if root.left:
#             root.left.next=root.right
#             if root.next:
#                 root.right.next=root.next.left
#         self.connect(root.left)
#         self.connect(root.right)
#         return root
