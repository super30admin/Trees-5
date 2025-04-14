# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    """
    TC:O(n)
    SC:O(h)
    """
    def __init__(self):
        self.firststartpoint=None
        self.lastendpoint=None
        self.prevnode = None
        
        
    def recoverTree(self, root: TreeNode) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        self.findsegment(root)
        temp=self.firststartpoint.val
        self.firststartpoint.val=self.lastendpoint.val
        self.lastendpoint.val=temp
        
    def findsegment(self, root):
        if root is None: return 
        self.findsegment(root.left)
        if self.prevnode:
            if self.prevnode.val>root.val:
                if self.firststartpoint is None:
                    self.firststartpoint=self.prevnode
                self.lastendpoint=root
        self.prevnode=root
        self.findsegment(root.right)
            
        
        
        