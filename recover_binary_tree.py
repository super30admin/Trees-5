#Time Compexity: O(N)
#Space Complexity: O(N)
class Solution(object):
    def recoverTree(self, root):
        """
        :type root: Optional[TreeNode]
        :rtype: None Do not return anything, modify root in-place instead.
        """
        self.first = self.second = self.prev = None

        def inorder(node):
            if not node:
                return

            inorder(node.left)


            if self.prev and self.prev.val > node.val:
                if not self.first:
                    self.first = self.prev
                self.second = node

            self.prev = node
            inorder(node.right)

        inorder(root)

        
        self.first.val, self.second.val = self.second.val, self.first.val
        