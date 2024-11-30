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
        if(root == None):
            return None
        
        self.helper(root.left,root.right)
        return root

    def helper(self,left,right):
        if(left == None):
            return
        
        left.next = right
        self.helper(left.left,left.right)
        self.helper(left.right,right.left)
        self.helper(right.left,right.right)