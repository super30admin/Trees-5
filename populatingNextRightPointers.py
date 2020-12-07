#Time Complexity : O(n) where n is the number of nodes in the tree
#Space Complexity : O(1)
#Did this code successfully run on Leetcode : Yes

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
    #BFS
    def connect(self, root: 'Node') -> 'Node':
        if not root:
            return root
        l = root
        while l.left:
            curr = l
            while curr:
                curr.left.next = curr.right
                if curr.next:
                    curr.right.next = curr.next.left
                curr = curr.next
            l = l.left
        return root

    #DFS - TC -> O(n) SC -> O(h)
    # def helper(self, l, r):
    #     if not l:
    #         return
    #     l.next = r
    #     self.helper(l.left, l.right)
    #     self.helper(l.right, r.left)
    #     self.helper(r.left, r.right)
    #
    # def connect(self, root: 'Node') -> 'Node':
    #     if not root:
    #         return
    #     self.helper(root.left, root.right)
    #     return root


#BRUTE FORCE - TC -> O(n) SC -> O(n)
#         if root is None:
#             return None
#         queue = [root]
#         while queue:
#             l = len(queue)
#             for i in range(l):
#                 curr = queue.pop(0)
#                 if i < l-1:
#                     curr.next = queue[0]
#                 if curr.left:
#                     queue.append(curr.left)
#                 if curr.right:
#                     queue.append(curr.right)

#         return root
