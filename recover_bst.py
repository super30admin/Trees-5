# Time Complexity : O(n)
# Space Complexity : O(n) considering stack space
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach
# I do inorder traversal and maintain previous node and whenever the previous node valus is smaller than the current node. I store prev and current node. If 
 # no other breaches happen return this else I assign the next current to the previous current and return both the variables
 
 
 # Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def recoverTree(self, root: TreeNode) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        
        self.first, self.last = None, None
        self.prev = None
        def helper(root):
            if not root:
                return
            helper(root.left)
            if self.prev and root.val < self.prev.val:
                if self.first is None:
                    self.first = self.prev
                    self.last = root
                else:
                    self.last = root
            self.prev = root
            helper(root.right)
        
        helper(root)
        temp = self.first.val
        self.first.val = self.last.val
        self.last.val = temp
