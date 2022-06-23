#Time Complexity: O(N)
#Space Complexity: O(N)

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
        stack = []
        prev = None
        first = None
        second = None
        while stack or root:
            while root:
                stack.append(root)
                root = root.left
            root = stack.pop()
            if prev and prev.val >= root.val:
                if not first and not second:
                    first = prev
                    second = root
                else:
                    second = root
                
            prev = root
            root = root.right
            
        first.val, second.val = second.val, first.val