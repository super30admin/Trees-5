# 99. Recover Binary Search Tree
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def recoverTree(self, root: Optional[TreeNode]) -> None:
        first = None
        second = None
        prev = None
        def helper(root):
            nonlocal first
            nonlocal second
            nonlocal prev
            #base
            if not root:return

            #logic
            helper(root.left)

            
            if prev and prev.val >= root.val:
                if not first: 
                    first = prev
                    second = root
                else:
                    second = root
            prev = root
            helper(root.right)
            
        helper(root)
        first.val,second.val = second.val,first.val
        return root



        
        