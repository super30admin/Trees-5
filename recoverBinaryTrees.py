# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
"""
Approach: If the values are sorted to an array and in the unsorted part of the list, we need to 
get the first leftmost greater element and the rightmost smallest. First element is basically the element where
the condition of prev > curr occurs and the rightmost smallest is the curr at the last condition break of
prev > curr.
t.c. => O(n)
s.c. => O(h)

"""
class Solution:
    def recoverTree(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        self.minNode, self.maxNode = None, None
        self.prev = None

        def helper(root):
            if not root:
                return
            helper(root.left)
            if self.prev:
                if self.prev.val > root.val:
                    if not self.maxNode:
                        self.maxNode = self.prev

                    self.minNode = root
            self.prev = root
            helper(root.right)
        helper(root)
        l, r = self.minNode.val, self.maxNode.val
        self.minNode.val = r
        self.maxNode.val = l
        return