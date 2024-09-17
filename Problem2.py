
#Time Complexity :- O(n)
#Space Complexity :- O(h)
#DFS approach 

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    first, second, prev = None, None, None
    def recoverTree(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        self.first, self.second, self.prev = None, None, None

        self.inorder(root)
        temp = self.first.val
        self.first.val = self.second.val
        self.second.val = temp
        return root
    
    def inorder(self, root):
        if root is None:
            return 
        
        self.inorder(root.left)
        if self.prev is not None and self.prev.val >= root.val:
            if self.first is None:
                self.first = self.prev
                self.second = root
            else:
                self.second = root
        self.prev = root
        self.inorder(root.right)


#Time Complexity :- O(n)
#Space Complexity :- O(h)
#Iterative approach 

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    first, second, prev = None, None, None
    def recoverTree(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        self.first, self.second, self.prev = None, None, None

        stack = []
        while root is not None or len(stack) > 0:
            while root is not None:
                stack.append(root)
                root = root.left
            root = stack.pop()
            if self.prev is not None and self.prev.val >= root.val:
                if self.first is None:
                    self.first = self.prev
                self.second = root
            self.prev = root
            root = root.right

        temp = self.first.val
        self.first.val = self.second.val
        self.second.val = temp 
        return root