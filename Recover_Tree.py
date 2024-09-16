# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def recoverTree(self, root: Optional[TreeNode]) -> None:
        
        prev=None
        first=None
        second=None
        
        if root is None:
            return
        
        def inorder(root):
            nonlocal prev,first,second
            if root is None:
                return
            
            inorder(root.left)
            
            if prev is not None and prev.val>root.val:
                if first is None:
                    first=prev
                    second=root
                else:
                    second=root
            prev=root
                    
            inorder(root.right)
            
            
        inorder(root)
        
        first.val,second.val=second.val,first.val
        
        return root