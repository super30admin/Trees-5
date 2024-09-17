# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
# Time Complexity: O(n)
# space Complexity: O(h)
class Solution:
    #     define first and last element and flag to chekc if first is updated or not
    first = TreeNode()
    last = TreeNode()
    flag = False
    prev = None

    #     Here we will check base condition
    # and call inorder on left subtree and after that we will chekc if root value is less than the orev val if prresent and iit is first mismatch we will assign first to prev and second to the current root and if not first mismatch we will just update second mismatched node to cuurent root
    # and we will call the function recursively on right sub tree of the tree
    def inorder(self, root):
        if not root:
            return

        self.inorder(root.left)

        if self.prev and root.val < self.prev.val:
            if not self.flag:
                self.first = self.prev
                self.last = root
                self.flag = True
            else:
                self.last = root

        self.prev = root
        self.inorder(root.right)

    def recoverTree(self, root):
        """
        Do not return anything, modify root in-place instead.
        """
        # We will perform inorder traversal on tree and we will get the first and
        # second misplaced element in the tree and in the end we will swap it
        self.inorder(root)
        self.first.val, self.last.val = self.last.val, self.first.val


