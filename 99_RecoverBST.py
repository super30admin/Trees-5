# Time Complexity: O(n)
# space Complexity: O(h)

# do inorder traversal
# in inorder root will in acending order, if tree is valid BST
# take three variable first, second and prev
# first will store --> first breach
# second will store --> second breach
# do traversal among the tree, and store prev for each root
# if we found prev > root, than we found our first breach
# store it on our first variable
# than move next and when we found same condition, we store that variable to our second variable
# swap first and and second variable and return.



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
        
        if root == None:
            return
        self.first  = None
        self.second = None
        self.prev = None
        self.inorder(root)
        self.first.val, self.second.val = self.second.val, self.first.val
        return root
    
    
    def inorder(self, root):
        if root == None:
            return
        self.inorder(root.left)
        if self.prev != None and self.prev.val >= root.val:
            if self.first == None:
                self.first = self.prev
                self.second = root
            else:
                self.second = root
        self.prev = root
        self.inorder(root.right)