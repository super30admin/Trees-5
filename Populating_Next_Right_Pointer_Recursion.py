# Created by Aashish Adhikari at 7:36 PM 2/15/2021

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

Logic: A level N+1 is encountered only after the level N has its next pointers correctly assigned. Leverage this.

Time Complexity:
O(n) where n is the number of nodes in the tree.

Space Complexity:
O(logn) for the recursive stack.
'''

class Solution(object):

    def helper(self, node):

        if node.left is not None:
            node.left.next = node.right

        if node.right is not None:
            if node.next is not None:
                node.right.next = node.next.left

        if node.left is not None:
            self.helper(node.left)
        if node.right is not None:
            self.helper(node.right)

    def connect(self, root):
        """
        :type root: Node
        :rtype: Node
        """

        if root is None:
            return None

        self.helper(root)

        return root
        
