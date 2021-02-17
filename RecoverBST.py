'''
TC - O(N) Visiting each node once
SC - O(N) Recursive stack
'''

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def recoverTree(self, root):
        """
        :type root: TreeNode
        :rtype: None Do not return anything, modify root in-place instead.
        """
        if not root:
            return
        self.first=TreeNode(None) # to store the first misplaced node
        self.second=TreeNode() # to store second misplaced word
        self.prev=TreeNode(None) # to keep a track of previous element which we need to compare with the current node
        self.helper(root) # Traversing through the nodes
        self.first.val,self.second.val=self.second.val,self.first.val # Swapping the 2 misplaced elements
         
    def helper(self,root):
        if root:
            self.helper(root.left)
            if self.prev!=None and self.prev.val>root.val:
                if self.first==None:
                    self.first=self.prev
                    self.second=root
                else:
                    self.second=root
            self.prev=root
            self.helper(root.right)
            
