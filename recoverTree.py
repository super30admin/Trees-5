# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def recoverTree(self, root: Optional[TreeNode]) -> None:
        """
        Approach:
        1. Use Morris In-Order Traversal to traverse the tree in O(1) space.
        2. Track the previous node and detect the two misplaced nodes when the order is violated.
        3. After traversal, swap their values to fix the tree.

        Time Complexity: O(N) — Each node is visited at most twice.
        Space Complexity: O(1) — No extra space is used (in-place).
        """
        stack = []
        first = second = prev = None

        while root or stack:
            while root:
                stack.append(root)
                root = root.left
            
            root = stack.pop()
            if prev and prev.val > root.val:
                if not first:
                    first = prev
                second = root
            prev = root
            root = root.right
        
        if first and second:
            first.val, second.val = second.val, first.val


        
