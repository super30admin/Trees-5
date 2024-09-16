# Time Complexity: O(n)
# Space Complexity: O(h) where h is the height of the tree, worse case - O(n)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this : No


# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def recoverTree(self, root):
        """
        :type root: TreeNode
        :rtype: None Do not return anything, modify root in-place instead.
        """
        if not root:
            return
        
        def helper(node):
            if not node:
                return
            
            helper(node.left)
            
            if self.prev!=None and self.prev.val>=node.val:
                if self.first==None:
                    self.first = self.prev
                    self.second = node
                else:
                    self.second = node
                    
            self.prev = node            
            helper(node.right)
            
        self.prev = None
        self.first = None
        self.second = None
        
        helper(root)

        self.first.val, self.second.val = self.second.val, self.first.val
        return root               