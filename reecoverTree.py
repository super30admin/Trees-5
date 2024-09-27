# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def inOrderTraversal(self, root: Optional[TreeNode]) -> None:
        if root is None:
            return []
        return self.inOrderTraversal(root.left) + [root] + self.inOrderTraversal(root.right)

    def recoverTree(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        inOrder = self.inOrderTraversal(root)

        # Find first inversion
        for i in range(len(inOrder)-1):
            if inOrder[i].val > inOrder[i+1].val:
                minNode = min(inOrder[i+1:], key=lambda node: node.val)
                inOrder[i].val, minNode.val = minNode.val, inOrder[i].val
