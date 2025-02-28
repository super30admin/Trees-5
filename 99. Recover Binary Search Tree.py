#Aprroach- Inorder traversal
# if val in recursion stack is greater than curr value then set first and second nodes then update the first and second nodes
#after recursion swap the values
#Time: O(n)
#Space: O(h)

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
        self.first=None
        self.second= None
        self.prev= None

        self.dfs(root)
        temp = self.first.val
        self.first.val= self.second.val
        self.second.val= temp
        
        return root

    def dfs(self,root):
        if root is None:
            return 
        
        self.dfs(root.left)
        if self.prev is not None and root.val < self.prev.val:
            if self.first is None:
                self.first= self.prev
            self.second= root
        self.prev= root
        self.dfs(root.right)

        return root
