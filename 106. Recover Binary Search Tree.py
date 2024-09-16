# Time Complexity: O(n)
# Space Complexity: O(h)

# --------------------Iterative Approach--------------------
class Solution:
    def recoverTree(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        stack = []
        prev = None
        first = None
        second = None
        
        while stack or root:
            while root:
                stack.append(root)
                root = root.left
            root = stack.pop()
            
            if prev!=None and prev.val>=root.val:
                if first is None:
                    first = prev
                    second = root
                else: second = root
                    
            prev = root        
            root = root.right

        first.val, second.val = second.val, first.val  
        return root

# --------------------Recursive Approach--------------------
class Solution:
    def __init__(self):
        self.prev = None
        self.first = None
        self.second = None
        
    def recoverTree(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        if root is None: return None
        self.helper(root)
        self.first.val, self.second.val = self.second.val, self.first.val
        return root
        
    
    def helper(self, root):
        if root is None: return
        
        self.helper(root.left)
        if self.prev != None and self.prev.val >= root.val:
            if self.first == None:
                self.first = self.prev
                self.second = root
            else:
                self.second = root
        self.prev = root
        self.helper(root.right)

