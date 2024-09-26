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
     
        def inorderTraversal(node):
            nonlocal first, second , prev
            if node is None:
                return 
            inorderTraversal(node.left)
            if prev and node.val<prev.val:
                second = node
                if first is None:
                    first = prev
                else:
                    return 
            prev = node
            inorderTraversal(node.right)
        
        first = second = prev = None
        inorderTraversal(root)
        first.val , second.val = second.val, first.val
