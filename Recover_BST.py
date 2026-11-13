# Time Complexity : O(N)
# Space Complexity : O(H)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# Using Iterative Inorder Traversal
# Append root in the stack. While stack is not empty we will pop the node
# If node is not Null and if it is visited and if prev is not None and prev.val >= node.val and if first is None then assign first to prev
# Assign second to node during the second breach we wont move the first pointer at the first breach
# Assign the prev to node to move the pointer to next node
# Then at the end we will swap first and second val


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def recoverTree(self, root: TreeNode | None) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        if not root:
            return None
        stack = [(root, False)]
        res = []
        first = None
        second = None
        while stack:
            node, visited = stack.pop()
            if node:
                if visited:
                    res.append(node)
                else:
                    stack.append((node.right, False))
                    stack.append((node, True))
                    stack.append((node.left, False))
        for i in range(1, len(res)):
            if res[i].val < res[i-1].val:
                if first is None:
                    first = res[i-1]
                second = res[i]

        first.val, second.val = second.val, first.val
# Inorder Traversal
#Space - O(N)

class Solution:
    def recoverTree(self, root: TreeNode | None) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        if not root:
            return None
        stack = [(root, False)]
        first = None
        second = None
        prev = None
        while stack:
            node, visited = stack.pop()
            if node:
                if visited:
                    if prev and prev.val > node.val:
                        if first is None:
                            first = prev
                        second = node
                    prev = node
                else:
                    stack.append((node.right, False))
                    stack.append((node, True))
                    stack.append((node.left, False))
        first.val, second.val = second.val, first.val
