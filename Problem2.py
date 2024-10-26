'''
1. To recover the BST, we use the inorder traversal of the tree as it gives us nodes in ascending order.
2. We keep track of two nodes, the previous and current. If in case a node doesn't follow ascending order, store it in first.
3. There will be only two nodes which we need to swap. Once traversal completes swap in place. 

TC: O(n)
SC: O(h)
'''
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

        if not root:
            return
        
        self.prev = None
        self.first = None
        self.second = None
        self.inorder(root)
        self.first.val, self.second.val = self.second.val, self.first.val

    def inorder(self, root):
        #base
        if not root:
            return  

        #logic
        self.inorder(root.left)
        if self.prev and self.prev.val > root.val:
            if not self.first:
                self.first = self.prev
            self.second = root
        self.prev = root
        self.inorder(root.right)