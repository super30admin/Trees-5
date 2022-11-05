"""
Approach --

A. Recursive approach --
1. Start from the root node. Run an inorder traversal (for left subtree) since we get list of nodes in ascending order
i.e. Left - Root - Right
2. Set falg to false. Use flag to check if 1st mismatch has been found. If no, on encountering 1st mismatch set flag to True
3. Use prev variable to compare if prev is less that root (i.e. curr element)
4. If prev is greater, assing the value of prev to first and the value of root to second
5. If not greater, assign the value of root to second (which means it's a second mismatch)
6. assign root to prev
7. Repeat the same process for inorder(right)

TC - O(n)
SC - O(h)
"""

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
        if not root: return

        self.prev = None
        self.first = None
        self.second = None
        self.flag = False

        def inorder(root):
            # base
            if not root: return

            # logic
            inorder(root.left)

            if self.prev and self.prev.val >= root.val:
                # if no mismatch found
                if self.flag == False:
                    self.flag = True
                    self.first = self.prev
                    self.second = root
                else:
                    # second mismatch
                    self.second = root
            self.prev = root
            inorder(root.right)

        # call inorder
        inorder(root)
        #swap mismatched elements
        self.first.val, self.second.val = self.second.val, self.first.val


