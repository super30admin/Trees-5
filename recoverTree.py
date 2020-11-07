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
        self.temp=[]
        def dfs(node):
            if not node:
                return
            
            dfs(node.left)
            self.temp.append(node)
            dfs(node.right)
            
        dfs(root)
        #print(self.temp)
        srt = sorted(n.val for n in self.temp)
        
        for i in range(0,len(srt)):
            self.temp[i].val = srt[i]
            
        