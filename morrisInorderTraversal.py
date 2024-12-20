# // Time Complexity :O(n)
# // Space Complexity :O(h)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


class Solution:      
    def inorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        result = []
        self.helper(root,result)
        return result

    def helper(self,root,result):

        #basecase
        if not root: return
        
        self.helper(root.left,result)
        result.append(root.val)
        self.helper(root.right,result)  