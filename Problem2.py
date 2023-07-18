'''
Problem:  Recover Binary Search Tree
Time Complexity: O(n), where n is given nodes
Space Complexity: O(1)
Did this code successfully run on Leetcode: Yes
Any problem you faced while coding this: No
Your code here along with comments explaining your approach:
       traverse tree in inorder fashion
       record first and second wnehever there is glitch
       at the end swap the first and second nodes
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
        self.first = None
        self.second = None
        self.prev = None
        
        def inorder(root):
            if root is None:
                return 

            inorder(root.left)
            if self.prev and self.prev.val >= root.val:
                if self.first is None:
                    self.first = self.prev
                self.second = root
            self.prev = root
            inorder(root.right)


        inorder(root)
        self.first.val, self.second.val = self.second.val, self.first.val