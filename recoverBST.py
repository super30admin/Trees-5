"""
Do inorder traversal and check for BST property violation
TC: O(n)
SP: O(h) for stack space
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def recoverTree(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        prev = first = sec = None
        def inorder(node):
            nonlocal prev, first, sec
            if not node:
                return 
            # Inorder traversal: left -> current -> right
            inorder(node.left)
            # Check if the current value is greater than the previous value
            if prev and node.val <= prev.val:
                if first is None:
                    first = prev
                    sec = node
                else:
                    sec = node
            prev = node   
            inorder(node.right)
        inorder(root)
        temp = first.val
        first.val = sec.val
        sec.val = temp
        
        