from collections import defaultdict,deque
# Definition for a Node.
class Node:
    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next

# class Solution:
#     def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
#         if not root : return None
#         q = deque()
#         q.append(root)
#         while q:
#             size = len(q)
#             for i in range(size):
#                 curr = q.popleft()
#                 if i!=size-1:
#                     curr.next = q[0]
#                 if curr.left:
#                     q.append(curr.left)
#                     # since a perfect treee if left exisits right will exisit
#                     q.append(curr.right)
#         return root


# class Solution:
#     def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
#         if not root : return None
#         level = root
#         while level.left:
#             curr = level
#             while curr:
#                 curr.left.next = curr.right
#                 if curr.next:
#                     curr.right.next = curr.next.left
#                 curr=curr.next
#             level = level.left
#         return root

# class Solution:
#     def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
#         if not root : return None
#         def helper(root):
#             if not root.left: return 
#             root.left.next = root.right
#             if root.next:
#                 root.right.next = root.next.left
#             helper(root.left)
#             helper(root.right)
#         helper(root)
#         return root

class Solution:
    def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
        if not root : return None
        def helper(left,right):
            if not left: return None
            left.next = right
            helper(left.left,left.right)
            helper(left.right,right.left)
            helper(right.left,right.right)

        helper(root.left,root.right)
        return root