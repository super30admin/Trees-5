# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# Time complexity - O(n)
# Space complexity - O(h)
class Solution:

    def recoverTree(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        def inorder(root):
            nonlocal prev, first, second, flag

            if root:
                inorder(root.left)
                if prev and root.val <= prev.val:
                    if not first:
                        first = prev
                    else:
                        flag = True
                    second = root
                prev = root
                if not flag:
                    inorder(root.right)
        
        prev = None
        first = None 
        second = None
        flag = False
        if root:
            inorder(root)
            first.val, second.val = second.val, first.val
            return
        
        

        
