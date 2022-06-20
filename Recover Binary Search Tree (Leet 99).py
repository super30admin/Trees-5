'''
Using inorder recursion
Time: O(n)
Space: recursive stack
'''

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def recoverTree(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        self.first = None
        self.second = None
        self.prev = None
        self.flag = False
        
        self.inorder(root) 
        
        self.first.val, self.second.val = self.second.val, self.first.val 
        
        
    def inorder(self, root):
        if root is None:
            return
        
        self.inorder(root.left)
        
        if self.prev != None and self.prev.val >= root.val:
            if self.flag == False:
                self.first = self.prev
                self.second = root
                self.flag = True
            else:
                self.second = root
            
        self.prev = root
        
        self.inorder(root.right)


'''
Using Iterative inorder recursion
Time: O(n)
Space: O(n) - for recursion
'''
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def recoverTree(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        self.first = None
        self.second = None
        self.prev = None
        self.flag = False
        
        st = list()
        while root != None or len(st) != 0:
            while root != None:
                st.append(root)
                root = root.left
            root = st.pop()
            
            if self.prev != None and self.prev.val >= root.val:
                if self.flag == False:
                    self.flag = True
                    self.first = self.prev
                    self.second = root
                else:
                    self.second = root
            self.prev = root
            root = root.right
        
        self.first.val, self.second.val = self.second.val, self.first.val 
        

'''
iterative - without flag variable
'''
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def recoverTree(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        self.first = None
        self.second = None
        self.prev = None

        st = list()
        while root != None or len(st) != 0:
            while root != None:
                st.append(root)
                root = root.left
            root = st.pop()
            
            if self.prev != None and self.prev.val >= root.val:
                if self.first is None and self.second is None:
                    self.first = self.prev
                    self.second = root
                else:
                    self.second = root
            self.prev = root
            root = root.right
        
        self.first.val, self.second.val = self.second.val, self.first.val 
        
        
     