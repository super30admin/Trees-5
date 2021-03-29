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
O(n)

Space Complexity:
O(1)

'''

class Solution(object):

    # Logic : Maintain a level pointer that points to the left child of the leftmost node in a level.
    #         Once a level ends, make this level pointer the next curr node.

    def connect(self, root):
        """
        :type root: Node
        :rtype: Node
        """

        if root is None:
            return None

        if root.left is not None:
            root.left.next = root.right

        curr = root
        level = root.left

        while curr.left is not None:

            curr.left.next = curr.right

            if curr.next is not None:
                curr.right.next = curr.next.left

            curr = curr.next

            if curr is None:
                curr = level # makes the left child is the curr

                level = curr.left


        return root






