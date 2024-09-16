#Time Complexity :O(n)
#Space Complexity :O(h) 
#Did this code successfully run on Leetcode :yes
#Any problem you faced while coding this : No
class Solution(object):
    frst=None
    last=None
    flag=False
    prev=None
    def recoverTree(self, root):
        """
        :type root: TreeNode
        :rtype: None Do not return anything, modify root in-place instead.
        """            
        if(root==None ):
            return root
        
        self.inorder(root)
        
        #exchange the values
        temp=self.last.val
        self.last.val=self.frst.val
        self.frst.val=temp
            
    def inorder(self,root):
            #base
        if(root==None):
            return 
            #logic
        self.inorder(root.left)
        if(self.prev!=None and self.prev.val>root.val):
                #first breach
            if(not self.flag):
                self.last=root
                self.frst=self.prev
                self.flag=True
            else:#2nd breach
                self.last=root
        self.prev=root
        self.inorder(root.right)
        
        