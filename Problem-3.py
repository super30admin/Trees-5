'''
    Time Complexity: O(n)
    Space Complexity: O(logn)
'''
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.result = []

    def inorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        if not root:
            return self.result

        self.helper(root)
        return self.result
    
    def helper(self, root):
        # base case
        if not root:
            return

        # logic
        self.helper(root.left)
        self.result.append(root.val)
        self.helper(root.right)