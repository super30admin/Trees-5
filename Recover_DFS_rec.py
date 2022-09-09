# Time complexity : O(n)
# Space complexity : O(h)
# Leetcode : Solved and submitted

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
        # check if root is None
        if not root:
            return 
        # flag to check for the first breach
        self.flag = False
        
        # first and second is used to store the TreeNode of the elements that needs to be swapped
        self.first = self.second =  TreeNode(0)
        self.prev = None
        
        # call the recursive function
        self.helper(root)
        
        # swap only the values
        temp = self.first.val
        self.first.val = self.second.val
        self.second.val = temp
    
    def helper(self, root):
        # base
        if not root:
            return
        
        #logic
        # recursive until left node
        self.helper(root.left)
        
        # check if prev is not None and prev is greater than root, only then we have our element at incorrect place
        if self.prev != None and self.prev.val > root.val:
            # if this is the first breach, then change flag to True and set the first curr and prev
            if not self.flag:
                self.flag = True
                self.first = self.prev
                self.second = root
            # for the other element, we will only update the second
            self.second = root
        
        # maintain the prev for every node
        self.prev = root
        
        # recursively call the root right 
        self.helper(root.right)
