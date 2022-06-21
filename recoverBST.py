#Time Complexity: O(n)
#Space Complexity: O(h)
class Solution:
    def recoverTree(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        self.prev = None
        self.first = None
        self.second = None
        self.helper(root)
        
        self.first.val,self.second.val = self.second.val,self.first.val
        
    def helper(self,root):
        if root == None:
            return
        
        self.helper(root.left)
        
        if self.prev and root.val<=self.prev.val:
            if self.first == None and self.second == None:
                self.first = self.prev
                self.second = root
            else: 
                self.second = root
            
        self.prev = root
                
        self.helper(root.right)
        
      
        
        
        