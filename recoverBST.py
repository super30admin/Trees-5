#Time complexity: O(n)
#Space complexity: O(h)
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
        if root is None:
            return
        self.st = []
        self.first = None
        self.second = None
        self.prev = None
        self.inorder(root)
        self.first.val, self.second.val = self.second.val, self.first.val
        
    def inorder(self, root):
        if root is None:
            return
        while root != None or self.st:
            while root != None:
                self.st.append(root)
                root = root.left
            root = self.st.pop()
            if self.prev != None and self.prev.val >root.val:
                if self.first is None:
                    self.first = self.prev
                    self.second = root
                else:
                    self.second = root  
            self.prev = root
            root = root.right
