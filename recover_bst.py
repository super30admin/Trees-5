# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# Time Complexity: O(n)
# Space Complexity: O(h) h = height of tree
class Solution:
    first = None
    last = None
    prev = None
    flag = 0
    def recoverTree(self, root: TreeNode) -> None:
        if(root == None):
            return
        self.helper(root)
        # swap values after out of place nodes are identified 
        self.temp = self.first.val
        self.first.val = self.last.val
        self.last.val = self.temp
        
    def helper(self, root):
        # base
        if(root == None):
            return
        
        #logic
        self.helper(root.left)
        # check if there is a breach
        if(self.prev != None and self.prev.val >= root.val):
            # if this is the first breach
            if(self.flag == 0):
                # "prev" node is the first out of place node
                # curr node is the last out of place node
                self.first = self.prev
                self.last = root
                self.flag = 1
            else:
                # current node is the last out of place node
                self.last = root
        self.prev = root
        self.helper(root.right)
        
        