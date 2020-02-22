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
        """
            Time Complexity - O(n)
            'n' is the number of nodes
            Space Complexity - O(h)
            'h' is the height of the tree
        """
        cur, prev = root, TreeNode(float('-inf'))
        drops, stack = [], []
        while cur or stack:
            if cur:
                stack.append(cur)
                cur = cur.left
            else:
                node = stack.pop()
                # if current value is less than prev value,
                # we found a breach
                if node.val < prev.val:
                    drops.append((prev, node))
                prev = node
                cur = node.right
        # swap with prev value and node value
        drops[0][0].val, drops[-1][1].val = drops[-1][1].val, drops[0][0].val
