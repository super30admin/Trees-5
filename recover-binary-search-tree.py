# Recursive
# Time O(n)
# Space O(n)
class Solution:
    def __init__(self):
        self.first = None
        self.second = None
        self.prev = None

    def recoverTree(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        self.dfs(root)
        temp = self.first.val
        self.first.val = self.second.val
        self.second.val = temp
    
    def dfs(self, root: Optional[TreeNode]) -> None:
        if root == None: return

        self.dfs(root.left)
        if self.prev != None and root.val <= self.prev.val:
            if self.first == None:
                self.first = self.prev
            self.second = root
        self.prev = root
        self.dfs(root.right)

# Iterative recursion solution
# Time O(n)
# Space O(n)
class Solution:
    def __init__(self):
        self.first = None
        self.second = None
        self.prev = None

    def recoverTree(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        stack = []
        #stack.append(root)
        while len(stack) > 0 or root != None:
            # left
            while(root != None):
                stack.append(root)
                root = root.left
            
            #root
            popped = stack.pop()
            
            if self.prev != None and self.prev.val >= popped.val:
                if self.first == None: self.first = self.prev
                self.second = popped
            self.prev = popped
            # right
            root = popped.right
                
        temp = self.first.val
        self.first.val = self.second.val
        self.second.val = temp