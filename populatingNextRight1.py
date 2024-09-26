#Time: O(n)
#Space: O(1)
#Program ran on leetcode successfully

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
        currPtr = root
        if root:
            nextPtr = root.left
        
        while (currPtr and nextPtr):
            currPtr.left.next = currPtr.right
            if currPtr.next:
                currPtr.right.next = currPtr.next.left
            currPtr = currPtr.next
            if not currPtr:
                currPtr = nextPtr
                nextPtr = currPtr.left
        
        return root