# Time Complexity : O(n)
# Space Complexity:o(h)
#  Did this code successfully run on Leetcode : Yes

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
        if root is None:
            return root

        _queue = []

        _queue.append(root)

        while _queue:
            curr = _queue.pop(0)
            size = len(_queue)

            if curr.left is not None:
                _queue.append(curr.left)
                _queue.append(curr.right)

            for i in range(0,size):
                curr1 = _queue.pop(0)

                curr.next = curr1
                if curr1.left is not None:
                    _queue.append(curr1.left)
                    _queue.append(curr1.right)

                curr = curr1

        return root


#    Approach 2:

"""
# Definition for a Node.
class Node:
    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next
"""
# Time Complexity : O(n)
# Space Complexity:o(1)
#  Did this code successfully run on Leetcode : Yes

class Solution:
    def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
        if root is None:
            return root

        level = root
        curr = level

        while level.left != None:
            while curr != None:
                curr.left.next = curr.right
                if curr.next is not None:
                    curr.right.next = curr.next.left

                curr = curr.next

            level = level.left
            curr = level

        return root





