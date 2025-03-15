#  https://leetcode.com/problems/binary-tree-inorder-traversal/

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def inorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        self.ans = []
        self.inorder(root)
        return self.ans
    
    def inorder(self,root):
        if root == None:
            return
        
        self.inorder(root.left)
        self.ans.append(root.val)
        self.inorder(root.right)

# TC: O(n)  
# SC: O(n) + rec stack space

#----------------------------------------------------------------
# Iterative approach

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def inorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        ans = []
        st = []

        while st or root:
            while root:
                st.append(root)
                root = root.left

            root = st.pop()
            ans.append(root.val)

            root = root.right
        return ans
    
    

# TC: O(n)  
# SC: O(n) 