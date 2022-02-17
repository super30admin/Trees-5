'''
TC: O(n)
SC: O(h)

Intuition: 

Imagine array that has inorder traversal of nodes, have two pointer nodes, prev and curr. Compare them both, 
if there is any violation, store them in first and second pointers. Move prev and curr again and find for next violation.
If found, store the curr in second pointer. 

Finally swap prev and curr

'''
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def __init__(self):
        self.prev = None
        self.first = None
        self.second = None
    
    def helper(self, root):
        if not root:
            return
        
    
        self.helper(root.left)
        if self.prev:
            if root.val < self.prev.val:
                self.first = self.prev if not self.first else self.first
                self.second = root
        self.prev = root
        self.helper(root.right)
    
    def recoverTree(self, root):
        """
        :type root: TreeNode
        :rtype: None Do not return anything, modify root in-place instead.
        """
        self.helper(root)
        self.first.val, self.second.val = self.second.val, self.first.val