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
        if not root: return []
    
        inorder = []
        def helper(root):
            nonlocal inorder
            if not root:
                return
            
            helper(root.left)
            inorder.append(root)
            helper(root.right)
        helper(root)
        f, s = None, None

        prev = inorder[0]
        cur = 1
        while cur < len(inorder):
            if prev.val > inorder[cur].val:
                if f is None: #can not just find each bad one at one time and assign it to f and then s(if f is not None) because as soon as you find one bad one, and assign it to f, you already have second bad one as well and that is the curr one because prev is bigger than it and hence curr is too small bc and prev is too big for the order
                    f = prev  
                s = inorder[cur]
            prev = inorder[cur]
            cur+=1
        
        if f and s:
            f.val, s.val = s.val, f.val

                    
            


        

