# TC : O(N)
# SC : O(H)

class Solution(object):

    def inorderTraversal(self, root):
        """
        :type root: Optional[TreeNode]
        :rtype: List[int]
        """
        self.result = []

        self.helper(root)
        return self.result

    def helper(self,root):

        if root is None: return
        self.helper(root.left)
        self.result.append(root.val)
        self.helper(root.right)