# Time Complexity : O(n) where n is number of elements in tree
# Space Complexity :O(1)
# Did this code successfully run on Leetcode :Yes
# Any problem you faced while coding this : No

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def recoverTree(self, root: TreeNode) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        # maintain first, middle, last
        self.first, self.middle, self.last, self.prev = None, None, None, None
        # inorder
        self.inorder(root)
        # Case1 if the two nodes have different parents
        if self.first and self.last:
            self.first.val, self.last.val = self.last.val, self.first.val
        # case2 if both nodes are on same branch
        elif self.first:
            self.first.val, self.middle.val = self.middle.val, self.first.val

        return root

    def inorder(self, node):
        if node:
            self.inorder(node.left)
            # if the value of present node is smaller than the past node and node is not the first node to be checked
            if (self.prev is not None and node.val < self.prev.val):
                # if we have not discovrd any faulty node like that before then insert it in first and middle
                # first is the faulty node and the middle is the next node which may be useful if both faulty nodes are adjacent
                if self.first is None:
                    self.first = self.prev
                    self.middle = node
                # if this is 2nd time we found a faulty node then insert in the last
                else:
                    self.last = node
                    return
            self.prev = node
            self.inorder(node.right)


