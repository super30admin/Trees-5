#Time Complexity: O(n)
#Space Complexity: O(n)

class Solution:
    def __init__(self):
        self.count = 0
        self.prev = None
        self.first = None
        self.second = None
    def recoverTree(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        self.dfs(root)
        temp = self.first.val
        self.first.val=self.second.val
        self.second.val = temp
    def dfs(self,root):
        if root is None:
            return
        if self.count<2:
            self.dfs(root.left)
        if self.prev and self.prev.val>root.val:
            self.count+=1
            if self.first is None:
                self.first = self.prev
            self.second = root
        self.prev = root
        if self.count<2:
            self.dfs(root.right)

