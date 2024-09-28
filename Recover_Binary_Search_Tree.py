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
        Recover Binary Search Tree
        Time Complexity : O(n)
        Space Complexity : O(n)
        """
        stack = []
        self.x = None
        self.y = None
        self.prev = None
        
        
        while stack or root is not None:
            while root is not None:
                stack.append(root)
                root = root.left
            top = stack.pop(-1)
            print(top.val)
            if self.prev is not None and self.prev.val > top.val:
                self.y = top
                if self.x is not None:
                    
                    break
                self.x = self.prev
            elif self.prev is None:
                self.prev = top
                
                self.prev = top
            root = top.right
            self.prev = top
            
        print(self.x,self.y)
        temp = self.x.val
        self.x.val = self.y.val
        self.y.val = temp

        