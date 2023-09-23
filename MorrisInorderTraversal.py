#Time Complexity:O(n)
#Space Complexity:O(n)

class Solution:
    def __init__(self):
        self.result = []
    def inorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        self.dfs(root)
        return self.result
    def dfs(self,root):
        if root is None:
            return
        self.dfs(root.left)
        self.result.append(root.val)
        self.dfs(root.right)

        