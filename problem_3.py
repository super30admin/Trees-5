"""
Time Complexity : O(n) where n is the total number of nodes in the tree.
Space Complexity : O(h) where h is the height of the tree. 
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right


class Solution:
    def __init__(self):
        self.result = []

    def inorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        if root == None:
            return root
        self.inorder(root)
        return self.result

    def inorder(self, root):
        # base
        if root == None:
            return

        # logic
        self.inorder(root.left)
        self.result.append(root.val)
        self.inorder(root.right)
