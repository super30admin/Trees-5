# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
'''
Inorder Traversal of a Binary Tree 
Time Complexity: O(n) because we are only traversing the tree for identifying the breached nodes. 
Space Complexity: O(1)+O(h) where h is the height of the tree, which is the space used by the recursion stack and O(1) is for the variables used to store the nodes.
'''
class Solution:
    def inorderTraversal(self, root: Optional[TreeNode]) -> List[int]:

        res = []

        def inorder(node):
            if not node:
                return
            inorder(node.left)
            res.append(node.val)
            inorder(node.right)
        
        inorder(root)

        return res

# ------------------    Iterative Approach       ----------------------
'''
Time Complexity: O(n) because we are only traversing the tree for identifying the breached nodes.
Space Complexity: O(h) where h is the height of the tree, which is the space used by the stack.
'''

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def inorderTraversal(self, root: Optional[TreeNode]) -> List[int]:

        stack = []
        res = []
        while stack or root:
            while root:
                stack.append(root)
                root = root.left
            root = stack.pop()
            res.append(root.val)
            root = root.right

        return res
