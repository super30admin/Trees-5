"""
# Definition for a Node.
class Node:
    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next
"""
# BFS - O(n) and O(n)
# class Solution:
#     def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
#         if root == None:
#             return None
#         q = deque()
#         q.append(root)
#         while(q):
#             size = len(q)
#             for i in range(size):
#                 curr = q.popleft()
#                 if i != size - 1:
#                     curr.next = q[0]
#                 if curr.left != None:
#                     q.append(curr.left)
#                     q.append(curr.right)
#         return root

# Time Complexity: O(n) where n is the number of nodes
# Space Complexity: O(1) Constant Space
class Solution:
    def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
        if root == None:
            return root
        leftEl = root
        while leftEl != None:
            cur = leftEl
            while cur != None:
                if cur.left != None:
                    cur.left.next = cur.right
                if cur.right != None and cur.next != None:
                    cur.right.next = cur.next.left
                cur = cur.next
            leftEl = leftEl.left
        return root