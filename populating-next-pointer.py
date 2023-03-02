# Time Complexity : O(N)
# Space Complexity : O(N)

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
        def helper(left, right):
            if not left:
                return
            left.next = right
            helper(left.left, left.right)
            helper(left.right, right.left)
            helper(right.left, right.right)

        if not root:
            return
        helper(root.left, root.right)
        return root
        # if not root: return None
        # q = deque()
        # q.append(root)
        # outhead = out = Node()
        # while q:
        #     size = len(q)
        #     head = newList = Node()
        #     for i in range(size):
        #         curr = q.popleft()
        #         temp = Node(curr.val)
        #         newList.next = temp
        #         newList = temp
        #         if curr.left: q.append(curr.left)
        #         if curr.right: q.append(curr.right)
        #     if q: newList.next = Node('#')
        #     out.next = head.next
        #     out = newList.next
        # return outhead.next
