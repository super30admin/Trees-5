# Time Complexity : O(n)
# Space Complexity : O(h)
from typing import Optional, TreeNode, List
class Solution:
    def inorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        if root == None:
            return []
        
        def helper(root):
            if root == None:
                return 
            
            helper(root.left)
            self.path.append(root.val)
            helper(root.right)

        self.path = []
        helper(root)
        return self.path