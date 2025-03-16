# Iterative using stack
# Time O(n)
# Space O(n)
class Solution:
    def inorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        stack = []
        result = []
        while len(stack) > 0 or root != None:
            # left
            while root != None:
                stack.append(root)
                root = root.left
            # root
            root = stack.pop()
            result.append(root.val)
            # right
            root = root.right
        return result