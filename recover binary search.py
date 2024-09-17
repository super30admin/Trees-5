# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right


# Time Complexity: O(n)
# Space Complexity: O(h) - h is the height of the tree

class Solution:
    def __init__(self):
        self.first = None
        self.second = None
        self.prev = None
    
    def recoverTree(self, root: TreeNode) -> None:
        if not root:
            return
        self.inorder(root)
        temp = self.first.val
        self.first.val = self.second.val
        self.second.val = temp

    def inorder(self, root: TreeNode) -> None:
        #base
        if not root:
            return
        #logic
        self.inorder(root.left)
        if self.prev and self.prev.val >= root.val:
            if not self.first:
                self.first = root
                self.second = self.prev
            else:
                self.first = root
        self.prev = root
        self.inorder(root.right)

      
