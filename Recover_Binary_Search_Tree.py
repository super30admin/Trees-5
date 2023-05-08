# Time Complexity : O(n), where n is the number of nodes in the binary search tree
# Space Complexity : O(h), where h is the height of the binary search tree.

# Definition for a binary tree node.
class TreeNode:
     def __init__(self, val=0, left=None, right=None):
         self.val = val
         self.left = left
         self.right = right
class Solution:
    def __init__(self):
        self.first = None
        self.second = None
        self.prev = None
    
    def recoverTree(self, root: TreeNode) -> None:
        self.inorderTraversal(root)
        self.first.val, self.second.val = self.second.val, self.first.val
    
    def inorderTraversal(self, node):
        if not node:
            return
        
        self.inorderTraversal(node.left)
        
        if self.prev and self.prev.val > node.val:
            if not self.first:
                self.first = self.prev
            self.second = node
        
        self.prev = node
        
        self.inorderTraversal(node.right)
