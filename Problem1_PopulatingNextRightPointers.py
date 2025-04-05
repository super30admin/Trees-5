# Time Complexity: O(n), where n - number of nodes in the tree
# Space Complexity: O(h), where h - height of the tree (recursion stack)

class Solution:
    def connect(self, root: 'Node') -> 'Node':
        if not root:
            return None

        self.dfs(root.left, root.right)
        return root

    def dfs(self, left: 'Node', right: 'Node') -> None:
        # base
        if not left:
            return

        # logic
        left.next = right
        self.dfs(left.left, left.right)
        self.dfs(left.right, right.left)
        self.dfs(right.left, right.right)

