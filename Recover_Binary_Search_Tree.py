# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
#Time:O(n)
#Space:O(logn)
class Solution:
    def recoverTree(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        if not root:
            return None
        self.previous = TreeNode(float("-inf"))
        self.first = None
        self.second = None
        self.flag = False

        
        def inorder(root):
            if not root:
                return
            inorder(root.left)
            if root.val<self.previous.val:
                print(root.val,self.previous.val)
                if not self.flag:
                    self.first = self.previous
                    self.second = root
                    self.flag = True
                else:
                    self.second = root
            self.previous = root
                
            inorder(root.right)
        inorder(root)
        self.first.val,self.second.val = self.second.val,self.first.val
        