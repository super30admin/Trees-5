# Time Complexity : O(N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :

# Your code here along with comments explaining your approach
# Use Morris Inorder Traversal (Left -> Root -> Right).
# If the current node has no left child, visit it and move right.
# Otherwise, find the inorder predecessor in the left subtree.
# If no thread exists, create one and move left.
# If the thread exists, remove it, visit the node, and move right.
# This restores the original tree structure.


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def inorderTraversal(self, root: TreeNode | None) -> list[int]:
        output = []
        if not root:
            return output
        def helper(root):
            if not root:
                return
            helper(root.left)
            output.append(root.val)
            helper(root.right)
        helper(root)
        return output
#DFS

class Solution:
    def inorderTraversal(self, root: TreeNode | None) -> list[int]:
        output = []
        if not root:
            return output
        stack = [(root, False)]
        while stack:
            node, visited = stack.pop()
            if node:
                if visited:
                    output.append(node.val)
                else:
                    stack.append((node.right, False))
                    stack.append((node, True))
                    stack.append((node.left, False))
        return output
# Iterative DFS

class Solution:
    def inorderTraversal(self, root: TreeNode | None) -> list[int]:
        curr = root
        res = []
        while curr:
            if not curr.left:
                # Process curr
                res.append(curr.val)
                # Move right
                curr = curr.right
            else:
                # Find predecessor in left subtree
                pre = curr.left
                # Create thread OR remove thread
                while pre.right and pre.right != curr:
                    pre = pre.right
                if pre.right is None:
                    pre.right = curr
                    curr = curr.left
                else:
                    pre.right = None
                    res.append(curr.val)
                    curr = curr.right
        return res
# Morris Traversal No extra space