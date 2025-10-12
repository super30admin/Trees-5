# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# This is Morris inorder traversal algo where I am creating a predecessor and pointing it to curr for every left to the right most tree.
# This doesn't use recursion stack or physical stack hence, space is O(1). and time complexity is O(n)
class Solution:
    def inorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        if not root: return []
        result = []
        curr = root
        while curr:
            if curr.left:
                pre = curr.left
                while pre.right and pre.right != curr:
                    pre = pre.right

                if pre.right == None:
                    pre.right = curr
                    curr = curr.left
                else:
                    pre.right = None
                    result.append(curr.val)
                    curr = curr.right
            else:
                result.append(curr.val)
                curr = curr.right

        return result

