# The recoverTree method fixes a binary search tree (BST) where two nodes are swapped.

# Use in-order traversal to detect swapped nodes:
# - Track the previous node (prev) during traversal.
# - If the current node's value is smaller than the previous node's value:
#   - Mark the current node as 'small' (second swapped node).
#   - Mark the previous node as 'big' (first swapped node) if not already set.

# After traversal, swap the values of the two swapped nodes.

# TC: O(n) - Each node is visited once during traversal.
# SC: O(h) - Space for the recursion stack, where h is the tree height.


from typing import Optional
from bst import TreeNode


class Solution:
    def recoverTree(self, root: Optional[TreeNode]) -> None:
        small = big = prev = None

        def inorder(r):
            nonlocal small, big, prev
            if not r:
                return
            inorder(r.left)
            if prev and prev.val > r.val:
                small = r
                if not big:
                    big = prev
            prev = r
            inorder(r.right)

        inorder(root)
        small.val, big.val = big.val, small.val