# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    """
    Approach: DFS - in order
    1) check for the BSt condition at each node and find the swap
    2) Swap can be either with the child node itself or any other node. It could be difficult to find which swap case the input has
        a) to solve this, make the swap pair where your find the first breach
        b) if the second breach is not found just swap this pair

    TC: O(n)
    SC: O(h)
    """

    def __init__(self):
        self.prev = None
        self.breach_found = False
        self.first_breach = None
        self.last_breach = None

    def recoverTree(self, root: TreeNode) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        self.in_order(root)
        # swap values when the nodes are found
        self.first_breach.val, self.last_breach.val = self.last_breach.val, self.first_breach.val
        return

    def in_order(self, node):
        # base
        if not node:
            return

        # logic
        self.in_order(node.left)

        if self.prev and self.prev.val >= node.val:  # breach found
            if self.breach_found:  # last breach
                self.last_breach = node
            else:  # first breach
                self.breach_found = True
                self.first_breach = self.prev
                self.last_breach = node
        self.prev = node
        self.in_order(node.right)
