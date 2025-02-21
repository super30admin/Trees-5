# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def inorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        # T: O(n), S: O(h)
        res = []
        stack = []
        cur = root

        # Iterative
        while cur or stack:
            while cur:
                stack.append(cur)
                cur = cur.left

            cur = stack.pop()
            res.append(cur.val)
            cur = cur.right

        # Recursive
        def inorder(root):
            # Base Case
            if not root:
                return
            # l -> R -> r
            inorder(root.left)
            res.append(root.val)
            inorder(root.right)

        # inorder(root)
        return res
