# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
'''
Time Complexity --> O(n) since we are touching every node of the tree
Space Complexity --> O(1) 

Using Deapth first search approach for the problem and finding first incoorect value and second incorrect value
'''
class Solution:
    def __init__(self):
        self.first = None
        self.second = None
        self.prev = None
    def recoverTree(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        self.dfs(root)
        self.first.val, self.second.val = self.second.val, self.first.val
        return root
    
    def dfs(self, root):
        if root!=None:
            # if self.prev:
            #     print(self.prev.val)
            self.dfs(root.left)
            if self.prev!=None:
                if self.prev.val>root.val and self.first==None:
                    self.first = self.prev
                    self.second = root
                
                elif self.prev.val>root.val:
                    self.second = root
            self.prev = root
            self.dfs(root.right)



