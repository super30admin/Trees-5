# Time complexity: O(n)
# Space complexity: O(h)

class Solution:
    def recoverTree(self, root: TreeNode) -> None:
        self.prev = None
        self.first = None
        self.second = None
        
        def inorder(node):
            if node:
                inorder(node.left)
                if self.prev and node.val < self.prev.val:
                    if not self.first:
                        self.first = self.prev
                    self.second = node
                self.prev = node
                inorder(node.right)
        
        inorder(root)
        self.first.val, self.second.val = self.second.val, self.first.val
