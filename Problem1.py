"""
I implemented this using an inorder traversal since it gives sorted values in a BST. If two nodes are swapped, the inorder sequence will be violated at one or two places. During traversal, I track where the order breaks and store the two nodes. After traversal, I simply swap their values to fix the BST.
Time Complexity: O(n)
Space Complexity: O(h)
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def recoverTree(self, root: Optional[TreeNode]) -> None:

        self.first = self.second = self.prev = None
        
        def inorder(node):
            if not node:
                return
            inorder(node.left)
            if self.prev and self.prev.val > node.val:
                if not self.first:
                    self.first = self.prev
                self.second = node
            self.prev = node
            inorder(node.right)

        inorder(root)
        self.first.val, self.second.val = self.second.val, self.first.val