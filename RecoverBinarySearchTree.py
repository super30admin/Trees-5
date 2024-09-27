
class Solution:
    # Time Complexity : o(N)
    # space Complexity : o(N)
    def recoverTree(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        if not root:
            return
        self.first = None
        self.second = None
        self.prev = None
        self.helper(root)
        temp = self.first.val
        self.first.val = self.second.val
        self.second.val = temp
        return root

    def helper(self, root):
        #basse
        if not root:
            return
        #logic
        self.helper(root.left)
        if self.prev != None and self.prev.val> root.val:
            if self.first == None:
                self.first = self.prev
                self.second = root
            else:
                self.second = root
        self.prev = root
        self.helper(root.right)