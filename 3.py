'''
Problem3 Morris Inorder Traversal (https://leetcode.com/problems/binary-tree-inorder-traversal/)
'''

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def inorderTraversal(self, root: Optional[TreeNode]) -> List[int]: # type: ignore
        result = []
        curr = root

        while curr != None:
            if curr.left == None:
                result.append(curr.val)
                curr = curr.right

            else:
                prev = curr.left
                while prev.right != None and prev.right != curr:
                    prev = prev.right
                if prev.right == None:
                    prev.right = curr
                    curr = curr.left

                else:
                    prev.right = None
                    result.append(curr.val)
                    curr = curr.right
        return result                        