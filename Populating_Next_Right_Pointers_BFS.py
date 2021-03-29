# Created by Aashish Adhikari at 7:28 PM 2/15/2021

"""
# Definition for a Node.
class Node(object):
    def __init__(self, val=0, left=None, right=None, next=None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next
"""

'''
Time Complexity:
O(n) as we reach all n nodes.

Space Complexity:
O(n/2) ~ O(n) as we store all the nodes of a single level in the deque at once and the last layer las n/2 nodes.
'''

class Solution(object):
    def connect(self, root):
        """
        :type root: Node
        :rtype: Node
        """

        if root is None:
            return None

        from collections import deque

        deque = deque()

        deque.append(root)

        while len(deque) != 0:

            size = len(deque)
            for idx in range(0, size):
                if idx != size-1:
                    deque[0].next = deque[1]

                if deque[0].left is not None:
                    deque.append(deque[0].left)
                if deque[0].right is not None:
                    deque.append(deque[0].right)

                deque.popleft()

        return root

