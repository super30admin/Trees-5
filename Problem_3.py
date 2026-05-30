# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def inorder(self, node, ans):
        if node.left:
            self.inorder(node.left, ans)
        ans.append(node.val)
        if node.right:
            self.inorder(node.right, ans)

    def inorderTraversal(self, root):
        if not root:
            return []
        ans = []
        self.inorder(root, ans)
        return ans
