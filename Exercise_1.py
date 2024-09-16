# Time Complexity: O(n)
# Space Complexity: O(1)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this : No


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
        if not root:
            return 
        
        level = root
        
        while(level.left!=None):
            curr = level
            while curr!=None:
                curr.left.next = curr.right
                if curr.next!=None:
                    curr.right.next = curr.next.left
                curr = curr.next
            level = level.left
            
        return root                                