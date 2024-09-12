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
        self.helper(root.left, root.right)
        
        # return root as the final answer
        return root
    
    def helper(self, left, right):
        
        # if left or right is None, then return from there
        if left == None:
            return
        
        # make the left's next as the right
        left.next = right
        
        # recusrively call the left side first for all sub-trees
        self.helper(left.left, left.right)
        
        # recusively call the right of left sub-tree and left of right sub-tree
        self.helper(left.right, right.left)
        
        # recursively call the right side for all the sub-trees
        self.helper(right.left, right.right)
