#Time o(n), space O(1)
class Solution:
    
    def __init__(self,first=None,second=None,flag=False,prev=None):
        self.first=first
        self.second = second
        self.flag=flag
        self.prev=prev
        
    def recoverTree(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        self.inorder(root)
        #Swapping the nodes
        temp=self.first.val
        self.first.val=self.second.val
        self.second.val=temp
        

        #Inorder traversal to find the discrepancy
    def inorder(self,root):
        if not root:
            return None
        
        self.inorder(root.left)
        
        if self.prev and self.prev.val>root.val:
            
            if self.flag==False:
                self.first=self.prev
                self.second=root
                self.flag=True
            else:
                self.second=root
                
        self.prev = root
        
        
        self.inorder(root.right)
            
