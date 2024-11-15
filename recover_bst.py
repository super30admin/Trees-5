# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

"""
Approach1: Since it is a BST, the inorder traversal will be sorted. We can do that store the result
in an array and sort it. TC: O(n) + n (log(n)), SC: O(n)
Approach2: keep track of pointers in the tree itself.
TC: O(n), SC: O(h)
"""
class Solution:
    def helper(self, root, prev):
        # base case
        if not root:
            return

        # recursive

        self.helper(root.left, prev)

        # check if there is a breach
        if (prev[0] and (prev[0].val >= root.val)):
            if self.first is None:
                self.first = prev[0]
                self.second = root
            else:
                self.second = root

        prev[0] = root

        self.helper(root.right, prev)

    def recoverTree(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        if not root:
            return root
        self.first, self.second = None, None
        prev = [None]
        self.helper(root, prev)
        if self.first:
            self.first.val, self.second.val = self.second.val, self.first.val

        return root






