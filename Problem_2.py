# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    # def recoverTree(self, root):
    #     path = []
    #     self.inorder(root, path)
    #     first = None
    #     second = None
    #     for i in range(len(path) - 1):
    #         curr = path[i]
    #         nextEle = path[i + 1]
    #         if curr.val >= nextEle.val:
    #             if not first:
    #                 first = curr
    #                 second = nextEle
    #             else:
    #                 second = nextEle
    #     temp = first.val
    #     first.val = second.val
    #     second.val = temp

    # def inorder(self, root, path):
    #     if not root:
    #         return
    #     self.inorder(root.left, path)
    #     path.append(root)
    #     self.inorder(root.right, path)

    def recoverTree(self, root):
        self.first, self.second, self.prev = None, None, None
        self.inorder(root)
        self.first.val, self.second.val = self.second.val, self.first.val

    def inorder(self, curr):
        if not curr:
            return
        self.inorder(curr.left)
        if self.prev and self.prev.val >= curr.val:
            if not self.first:
                self.first = self.prev
                self.second = curr
            else:
                self.second = curr
        self.prev = curr
        self.inorder(curr.right)
