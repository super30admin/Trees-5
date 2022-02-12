# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Yes

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from typing import Optional


class Solution:
    def recoverTree(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        x = None
        y = None
        mo_pred = None
        pred = None

        while root:
            # If there is a left child
            if root.left:
                # predecessor node is one step left
                # and then right till you can.
                mo_pred = root.left

                while mo_pred.right and mo_pred.right != root:
                    mo_pred = mo_pred.right

                # set link predecessor.right = root
                # and go to explore left subtree
                if mo_pred.right is None:
                    mo_pred.right = root
                    root = root.left

                # link is broken : time to change subtree and go right
                else:
                    # check for swapped nodes
                    if pred and root.val < pred.val:
                        y = root

                        if x is None:
                            x = pred

                    pred = root

                    mo_pred.right = None

                    root = root.right
            # if no left child then go right.
            else:
                # check for the swapped nodes
                if pred and root.val < pred.val:
                    y = root
                    if x is None:
                        x = pred
                pred = root

                root = root.right

        x.val, y.val = y.val, x.val
