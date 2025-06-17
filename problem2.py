'''
// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english : same implementation as in class

// Your code here along with comments explaining your approach
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
            return None
        prev = first = second = None

        def inorder(root):
            if not root: return None
            nonlocal prev, first, second
            inorder(root.left)
            if prev and prev.val >= root.val:
                if not first:
                    first = prev
                second = root
            prev = root
            inorder(root.right)
        
        inorder(root)
        first.val, second.val = second.val, first.val
