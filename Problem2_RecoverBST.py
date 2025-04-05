# Time Complexity: O(n), where n - number of nodes in the tree
# Space Complexity: O(h), where h - height of the tree (recursion stack)

class Solution:
    def recoverTree(self, root: TreeNode) -> None:
        if not root:
            return None

        self.prev = None
        self.first = None
        self.last = None
        self.is_first = False

        # Using inorder traversal, track the first and last node that doesn't satisfy the BST condition
        self.inorder(root)

        # Swap the values of the two nodes
        self.first.val, self.last.val = self.last.val, self.first.val

    def inorder(self, root):
        # base
        if not root:
            return

        # logic
        self.inorder(root.left)

        # If prev node becomes greater than curr node in the inorder traversal, track the nodes and set prev to curr
        if self.prev and self.prev.val >= root.val:
            if not self.is_first:
                self.is_first = True
                self.first = self.prev
                self.last = root
            else:
                self.last = root

        self.prev = root
        self.inorder(root.right)