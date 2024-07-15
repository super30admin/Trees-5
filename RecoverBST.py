# Time Complexity : O(n)
# Space Complexity : O(1)

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def recoverTree(self, root: TreeNode) -> None:
        if not root:
            return

        first, second, prev, cur = None, None, None, root

        while cur:
            if not cur.left:
                if prev and prev.val > cur.val:
                    if not first:
                        first = prev
                    second = cur
                prev = cur
                cur = cur.right
            else:
                leftNode = cur.left
                while leftNode.right and leftNode.right != cur:
                    leftNode = leftNode.right

                if not leftNode.right:
                    leftNode.right = cur
                    cur = cur.left
                else:
                    leftNode.right = None
                    if prev and prev.val > cur.val:
                        if not first:
                            first = prev
                        second = cur
                    prev = cur
                    cur = cur.right

        if first and second:
            first.val, second.val = second.val, first.val

def print_inorder(root):
    if root is None:
        return []
    return print_inorder(root.left) + [root.val] + print_inorder(root.right)

# Example 1
root1 = TreeNode(1, TreeNode(3, None, TreeNode(2)))
print("Before recovery:", print_inorder(root1))
sol = Solution()
sol.recoverTree(root1)
print("After recovery:", print_inorder(root1)) # Output: [1, 2, 3]

# Example 2
root2 = TreeNode(3, TreeNode(1), TreeNode(4, TreeNode(2)))
print("Before recovery:", print_inorder(root2))
sol.recoverTree(root2)
print("After recovery:", print_inorder(root2)) # Output: [1, 2, 3, 4]

# Example 3
root3 = TreeNode(3, TreeNode(2, TreeNode(1)), TreeNode(4, None, TreeNode(5)))
print("Before recovery:", print_inorder(root3))
sol.recoverTree(root3)
print("After recovery:", print_inorder(root3)) # Output: No Change