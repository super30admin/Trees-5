# Time Complexity: O(n)
# Space Complexity: O(n)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    
    def inorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        self.res = []  # Initialize the result list
        self.helper(root)
        return self.res  # Return the result list after helper function
        
    def helper(self, root):
        if root == None:
            return
        self.helper(root.left)
        self.res.append(root.val)
        self.helper(root.right)
