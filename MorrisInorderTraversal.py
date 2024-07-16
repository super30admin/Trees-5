# Time Complexity:
# O(n)

# Space Complexity:  
# O(h)

# Approach: 
# Inorder traversal


# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def __init__(self):
        self.inorderList = []

    def inorderTraversal(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        if not root:
            return
        
        # recurse the tree, using inorder traversal
        self.inorder(root)

        return self.inorderList

    def inorder(self, root):
        if not root:
            return
        
        # left
        self.inorder(root.left)

        # root
        self.inorderList.append(root.val)

        # right
        self.inorder(root.right)