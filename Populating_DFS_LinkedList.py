# Time complexity : O(n)
# Space complexity : O(h)
# Leetcode : Solved and submitted

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
        # check if root is null
        if not root:
            return None
        
        # pass two parameters as root.left and root.right
        self.helper(root)
        
        # return root as the final answer
        return root
    
    def helper(self, root):
        
        # check if any of the root's child is None, return 
        if root.left == None:
            return
        
        # make a pointer for root's left to root's right
        root.left.next = root.right
        
        # if next element of root is not None
        if root.next != None:
            # make a link between root's right to next root's left
            root.right.next = root.next.left
        
        # recursively call the tree on the left and right
        self.helper(root.left)
        self.helper(root.right)
