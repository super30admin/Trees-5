"""
MORRIS TRAVERSAL
TC - O(n)
SC - O(1)
"""


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def inorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        if not root: return []

        curr = root
        rtnData = []

        while curr is not None:
            if curr.left is None:
                rtnData.append(curr.val)
                curr = curr.right
            else:
                # go to its rightmost node
                pre = curr.left
                # traverse to right most node till right child is None
                while pre.right is not None and pre.right != curr:
                    pre = pre.right

                # found the right most node. link the curr to this rightmost nodes right
                if pre.right is None:
                    pre.right = curr
                    # now go back to curr's left child which is not processed
                    curr = curr.left
                else:
                    # restore tree structure
                    pre.right = None
                    rtnData.append(curr.val)
                    curr = curr.right
        return rtnData

