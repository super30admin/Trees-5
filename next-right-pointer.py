"""
# Definition for a Node.
class Node(object):
    def __init__(self, val=0, left=None, right=None, next=None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next
"""
from collections import deque
class Solution(object):
    def connect(self, root):
        """
        :type root: Node
        :rtype: Node
        """
#         if not root:
#             return
#         q=deque()
#         q.append(root)
#         while q:
#             l=len(q)
#             for i in range(l):
#                 curr=q.popleft()
#                 if i!=l-1:
#                     curr.next=q[0]

#                 if curr.left:
#                     q.append(curr.left)
#                     q.append(curr.right)
#         return root
#time-O(n) space-O(n)

        # if not root:
        #     return
        # level=root
        # while level.left:
        #     curr=level
        #     while curr:
        #         curr.left.next=curr.right
        #         if curr.next:
        #             curr.right.next=curr.next.left
        #         curr=curr.next
        #     level=level.left
        # return root
        #      #time-O(n) space-O(1)

        def dfs(left,right):
            if left==None:
                return
            left.next=right
            dfs(left.left,left.right)
            dfs(left.right,right.left)
            dfs(right.left,right.right)
        if root==None:
            return
        dfs(root.left,root.right)
        return root
    #time,space=O(n)