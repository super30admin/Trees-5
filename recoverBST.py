# time complexity: O(n)
# space complexity: O(1)
def recoverTree(self, root: Optional[TreeNode]) -> None:
    """
    Do not return anything, modify root in-place instead.
    """
    self.prev = None
    self.curr  = None
    self.first = None
    self.second = None
    if root is None:
        return
    
    self.helper(root)
    # swap first and second
    if self.first and self.second:

        temp = self.first.val
        self.first.val = self.second.val
        self.second.val = temp

def helper(self,root):
    # base
    if root is None:
        return
    # logic
    self.helper(root.left)
    if self.prev!=None and root.val <= self.prev.val:
        # breach
        if  self.first is None:
            # first breach
            self.first = self.prev
        self.second = root
    self.prev = root 
    self.helper(root.right)



    