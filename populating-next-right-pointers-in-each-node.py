'''
TC: O(n)
SC: O(1)

Intuition:

Maintain level pointer and curr pointer. Make the connections in the next level using the current level.


'''

"""
# Definition for a Node.
class Node(object):
    def __init__(self, val=0, left=None, right=None, next=None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next
"""

class Solution(object):
    def connect(self, root):
        """
        :type root: Node
        :rtype: Node
        """
        
        level = root
        
        while level:
            curr = level
            while curr:
                if curr.left:
                    curr.left.next = curr.right
                if curr.right:
                    curr.right.next = curr.next.left if curr.next else None
                curr = curr.next
            level = level.left if level.left else level.right
        
        return root
        