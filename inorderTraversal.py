# TC: O(n)
# SC: O(1) auxiliary
class Solution:
    def inorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        res=[]
        def helper(root):
            nonlocal res
            #base
            if not root:
                return
            #logic
            helper(root.left)
            res.append(root.val)
            helper(root.right)
        
        helper(root)
        return res
