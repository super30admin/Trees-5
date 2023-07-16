# Time Complexity : O(n)
# Space Complexity : O(h)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def recoverTree(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """

        first, second, prev = None, None, None

        def helper(root):
            nonlocal first, second, prev
            if not root:
                return
            helper(root.left)
            if prev and prev.val > root.val:
                if first:
                    second = root
                if not first:
                    first = prev
                    second = root
            prev = root
            helper(root.right)
        
        helper(root)
        first.val, second.val = second.val, first.val
        return root