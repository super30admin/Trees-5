# // Time Complexity : O(n)
# // Space Complexity : O(n)

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    prev = None
    first = None
    last = None
    flag = False  #to record if the first breach has already happened

    def recoverTree(self, root: TreeNode) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        print(self.prev)
        if root == None:
            return
        self.inorder(root)
        temp = self.first.val
        self.first.val = self.last.val
        self.last.val = temp

    def inorder(self, root):
        # Base
        if root == None:
            return
        # logic
        self.inorder(root.left)
        if self.prev != None and self.prev.val >= root.val:
            if not self.flag:
                # Breach 1
                self.first = self.prev
                self.last = root
                self.flag = True
            else:
                # Breach 2
                self.last = root
                # if both the breaches are done, then no need to proceed further
                return
        self.prev = root
        self.inorder(root.right)