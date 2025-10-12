# Time Complexity : O(N) where N is the number of nodes in the binary tree
# Space Complexity : O(h) where h is the height of the binary tree
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach:
# I am using inorder traversal to traverse the binary tree. I will keep track of the previous node and the current node.
# If the previous node's value is greater than the current node's value, then I have found a violation.
# I will keep track of the first and second nodes that are out of order.
# If I find a violation, I will update the first and second nodes accordingly.
# After the traversal, I will swap the values of the first and second nodes to recover the binary search tree.

from typing import Optional
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def recoverTree(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        self.first = None
        self.sec = None
        self.prev = None
        def helper(root):
            if root is None:
                return 
            helper(root.left)
            if self.prev and self.prev.val > root.val:
                if not self.first:
                    self.first = self.prev
                self.sec = root
            self.prev = root
            helper(root.right)
           
        helper(root)
        self.first.val, self.sec.val = self.sec.val, self.first.val
        return root
                

