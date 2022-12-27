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
        
        ## T.C = O(n)
        ## S.C = O(h)
        
        f_s = [None, None]
        prev = None

        def dfs(root):
            nonlocal prev

            if not root:
                return
            
            dfs(root.left)
            if prev is not None and prev.val > root.val:
                if f_s[0]==None:
                    f_s[0] = prev
                f_s[1] = root
            
            prev = root

            dfs(root.right)
            
        dfs(root)

        f_s[0].val, f_s[1].val = f_s[1].val, f_s[0].val
        