#As taught in class, using modified inorder traversal to find breaches while recovering the binary search tree to avoid using extra space.
#Time Complexity: O(h)
#Space Complexiity: O(1)
class Solution:
    def __init__(self):
        self.first = None
        self.last = None
        self.prev = None
        
    def recoverTree(self, root: TreeNode) -> None:
        if root is None:
            return
        self.inorder(root)
        temp = self.first.val
        self.first.val = self.last.val
        self.last.val = temp
        
    def inorder(self,root):
        if root is None:
            return
        self.inorder(root.left)
        if self.prev!= None and self.prev.val >= root.val:
            if self.first is None:
                self.first = self.prev
                self.last = root
            else:
                self.last = root
        self.prev = root
        self.inorder(root.right)