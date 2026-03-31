# Time Complexity : O(n)
# Space Complexity : O(h)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Approach : We do an in-order traversal iteratively to detect two nodes where the BST property is violated.
# We track the first and second misplaced nodes using a previous pointer.
# After traversal, we simply swap their values to restore the BST.

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.prev = None
        self.first = None
        self.second = None

    def recoverTree(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        st = []
        while st or root:
            while root:
                st.append(root)
                root = root.left

            root = st.pop()

            if self.prev and self.prev.val >= root.val:
                if not self.first:
                    self.first = self.prev
                self.second = root

            self.prev = root
            root = root.right

        temp = self.first.val
        self.first.val = self.second.val
        self.second.val = temp


        