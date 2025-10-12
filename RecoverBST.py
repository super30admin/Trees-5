# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

#Time is O(n) and space O(h) where is h is height of the tree.
# The logic is to do an inorder traversal and find the breaches, at most we can have 2 breaches due to swapping 2 nodes. Once we find the first and second val of the breaches.
# Then just swap them to recover the BST

class Solution:
    def recoverTreeRecursive(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        if not root: return
        self.first = None
        self.second = None
        self.prev = None

        def helper(curr):
            if not curr:
                return
            helper(curr.left)
            if (self.prev != None and self.prev.val >= curr.val):
                if (self.first is None):
                    self.first = self.prev
                    self.second = curr
                else:
                    self.second = curr
            self.prev = curr

            helper(curr.right)

        helper(root)
        self.first.val, self.second.val = self.second.val, self.first.val

    # This is iterative approach. The logic is pretty much the same. We use physical stack here instead of the recursive stack in recursion.
    # Time and space is same: O(n) and O(h)
    def recoverTree(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        st = []
        prev = None
        first = None
        second = None
        while st or root:
            while root:
                st.append(root)
                root = root.left
            root = st.pop()
            if (prev != None and prev.val >= root.val):
                if (first is None):
                    first = prev
                    second = root
                else:
                    second = root
            prev = root
            root = root.right
        first.val, second.val = second.val, first.val