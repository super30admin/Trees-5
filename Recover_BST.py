# Time Complexity : O(n)
# Space Complexity : O(h).
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
#
#

# iterative.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def recoverTree(self, root) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        prev = None
        first = None
        second = None
        stack = []
        while stack or root:
            while root:
                stack.append(root)
                root = root.left
            pop = stack.pop()
            if prev and prev.val > pop.val:
                if not second:
                    first = prev
                    second = pop
                else:
                    second = pop
            prev = pop
            root = pop.right
        first.val, second.val = second.val, first.val


root = TreeNode(6)
root.left = TreeNode(2)
root.right = TreeNode(8)
root.left.left = TreeNode(0)
root.left.right = TreeNode(4)
root.right.left = TreeNode(7)
root.right.right = TreeNode(9)
root.left.right.left = TreeNode(3)
root.left.right.right = TreeNode(5)
print(Solution().recoverTree(root))


# recursive
# TC: O(n); SC: O(h)
# class Solution:
#     def helper(self, root):
#         # base
#         if root is None:
#             return
#         # logic
#         self.helper(root.left)
#         if self.prev and self.prev.val > root.val:
#             if not self.second:
#                 self.first = self.prev
#                 self.second = root
#             else:
#                 self.second = root
#         self.prev = root
#         self.helper(root.right)
#
#     def recoverTree(self, root) -> None:
#         """
#         Do not return anything, modify root in-place instead.
#         """
#         self.prev = None
#         self.first = None
#         self.second = None
#         self.helper(root)
#         self.first.val, self.second.val = self.second.val, self.first.val
#
#
# root = TreeNode(6)
# root.left = TreeNode(2)
# root.right = TreeNode(8)
# root.left.left = TreeNode(0)
# root.left.right = TreeNode(4)
# root.right.left = TreeNode(7)
# root.right.right = TreeNode(9)
# root.left.right.left = TreeNode(3)
# root.left.right.right = TreeNode(5)
# print(Solution().recoverTree(root))


# TC: O(n*log(n)) + O(n) + O(n); SC: O(n)
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
#
#
# class Solution:
#     def inorder1(self, root):
#         # base
#         if not root:
#             return
#         # logic
#         self.inorder1(root.left)
#         self.stack.append(root.val)
#         self.inorder1(root.right)
#
#     def inorder2(self, root):
#         # base
#         if root is None:
#             return
#         # logic
#         self.inorder2(root.left)
#         if root.val != self.stack[self.ptr]:
#             root.val = self.stack[self.ptr]
#         self.ptr += 1
#         self.inorder2(root.right)
#
#     def recoverTree(self, root) -> None:
#         """
#         Do not return anything, modify root in-place instead.
#         """
#         self.stack = []
#         self.inorder1(root)
#         self.stack.sort()
#         self.ptr = 0
#         self.inorder2(root)
#
#
# root = TreeNode(6)
# root.left = TreeNode(2)
# root.right = TreeNode(8)
# root.left.left = TreeNode(0)
# root.left.right = TreeNode(4)
# root.right.left = TreeNode(7)
# root.right.right = TreeNode(9)
# root.left.right.left = TreeNode(3)
# root.left.right.right = TreeNode(5)
# print(Solution().recoverTree(root))
