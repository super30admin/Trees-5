# Recursive Solution
class Solution:
    def recoverTree(self, root) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        # Time Complexity - O(n)
        # Space Complexity - O(h) resulting from the inorder traversal
        self.first = None
        self.second = None
        self.prev = None

        if root is None:
            return

        self.inorder(root)
        self.first.val, self.second.val = self.second.val, self.first.val

    def inorder(self, root):
        # Base
        if root is None:
            return

        # Logic
        self.inorder(root.left)
        if self.prev is not None and self.prev.val >= root.val:
            if (self.first is None):
                self.first = self.prev
                self.second = root
            else:
                self.second = root
                return

        self.prev = root
        self.inorder(root.right)

# Iterative Solution
class Solution:
    def recoverTree(self, root) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        # Time Complexity - O(n)
        # Space Complexity - O(h) because of the inorder traversal
        prev = first = second = None
        stack = []
        while True:
            while root:
                stack.append(root)
                root = root.left
            if not stack:
                break
            node = stack.pop()
            if not first and prev and prev.val > node.val:
                first = prev
            if first and prev and prev.val > node.val:
                second = node
            prev = node
            root = node.right

        first.val, second.val = second.val, first.val