# Time Complexity O(n)
# Space complexity O(h)
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
        prev = None
        first = None
        second = None
        def inorder(root):
            nonlocal prev
            nonlocal first
            nonlocal second
            if root == None: return 

            inorder(root.left)

            if prev != None and root.val <= prev.val:
                if first == None:
                    first = prev
                    second = root
                else:
                    second = root

            prev = root
            inorder(root.right)
        inorder(root)
        temp = first.val
        first.val = second.val
        second.val = temp

       