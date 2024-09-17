# 
# Time: O(N)
#Space: O(H)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def recoverTree(self, root: Optional[TreeNode]) -> None:
        """
        instantiate parent node, first its null then has value. rep prev val
        instant switch = [None, None]
        
        dfs fxn(root)
            base case Root is null ret root
            
            dfs(root.left)
                #logic
                if self.parent and self.parent.val > root.val:
                    switch[1] = root.val if switch[1] == None else switch[1]
                    switch[0] = root
 
                self.parent = root
                dfs(root.right)
            dfs(root)
            switch[0].val, switch[1].val = switch[1].val, switch[0].val 
        
        
        """
        self.parent = None
        switch = [None,None]
        def dfs(root):
            if root is None: return root
            
            dfs(root.left)
                #logic
            if self.parent and self.parent.val > root.val:
                if switch[1] == None:
                    switch[1] = self.parent
                else: switch[1] = switch[1]
                switch[0] = root
 
            self.parent = root
            dfs(root.right)
        dfs(root)
        switch[0].val, switch[1].val = switch[1].val, switch[0].val 