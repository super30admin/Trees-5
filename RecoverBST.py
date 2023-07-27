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
        if root is None:
            return
        first = None
        sec = None
        prev = None

        def inorder(node):
            nonlocal first, sec, prev
            if node is None:
                return
        
            inorder(node.left)
            if prev is not None and node.val <= prev.val:
                if first == None:
                    first = prev
                    sec = node
                else:
                    sec = node
            prev = node
            inorder(node.right)
        
        inorder(root)
        first.val , sec.val = sec.val, first.val


            