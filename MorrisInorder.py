class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def inorderTraversal(self, root: TreeNode):
        res = []
        self._inorder(root, res)
        return res
    
    def _inorder(self, node, res):
        if node:
            self._inorder(node.left, res)
            res.append(node.val)
            self._inorder(node.right, res)

#time = O(N)
#space = O(H)