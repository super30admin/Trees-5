#The inorderTraversal function traverses the tree by first recursively visiting the left subtree, then processing the root node, and finally recursively visiting the right subtree. This ensures that nodes are added to the result list in ascending order of their values. Specifically, the function checks if the root is not None, then recursively extends the result list with the values from the left subtree, appends the current root's value, and extends it again with values from the right subtree. The space complexity of this solution is O(h), where h is the height of the tree, due to the recursion stack. The time complexity is O(n), where n is the number of nodes in the tree, as each node is visited exactly once.

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def inorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        result = []
        if root:
            result.extend(self.inorderTraversal(root.left))
            result.append(root.val)
            result.extend(self.inorderTraversal(root.right))
        return result
            