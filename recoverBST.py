# TC: O(n)
# SC: O(1)
class Solution:
    def recoverTree(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        first=second=prev=None
        def helper(root):
            nonlocal first,second,prev
            #base
            if not root:
                return 
            #logic
            helper(root.left)
            if prev and prev.val > root.val:
                if not first:
                    first = prev
                second = root
            prev=root
            helper(root.right)

        helper(root)
        
        first.val, second.val = second.val, first.val


