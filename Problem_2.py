# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def recoverTree(self, root: Optional[TreeNode]) -> None:
        if root == None:
            return None
        self.flag = False
        self.first, self.last, self.prev = None, None, None
        self.inorder(root)
        temp = self.first.val
        self.first.val = self.last.val
        self.last.val = temp
        
    def inorder(self, root):
        if root == None:
            return None
        self.inorder(root.left)
        if self.prev != None and self.prev.val >= root.val:
            if not self.flag:
                self.first = self.prev
                self.last = root
                self.flag = True
            else:
                self.last = root
                return
        self.prev = root
        self.inorder(root.right)

# Time Complexity: O(n)
# Space Complexity: O(n) Due to recursive stack space.