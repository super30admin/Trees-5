# Time Complexity : O(n)
# Space Complexity : O(h)

from typing import List

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def __init__(self):
        self.result = []

    def inorderTraversal(self, root: TreeNode) -> List[int]:
        if root is None:
            return self.result
        self.inorderTraversal(root.left)
        self.result.append(root.val)
        self.inorderTraversal(root.right)
        return self.result

# Example 1
root1 = TreeNode(1, None, TreeNode(2, TreeNode(3)))
sol1 = Solution()
output1 = sol1.inorderTraversal(root1)
print("Inorder Traversal of Example 1:", output1)  # Output: [1, 3, 2]

# Example 2
root2 = TreeNode(1, TreeNode(2), TreeNode(3, TreeNode(4), TreeNode(5)))
sol2 = Solution()
output2 = sol2.inorderTraversal(root2)
print("Inorder Traversal of Example 2:", output2)  # Output: [2, 1, 4, 3, 5]

# Example 3
root3 = TreeNode(1, TreeNode(2, TreeNode(3), TreeNode(4)), TreeNode(5))
sol3 = Solution()
output3 = sol3.inorderTraversal(root3)
print("Inorder Traversal of Example 3:", output3)  # Output: [3, 2, 4, 1, 5]