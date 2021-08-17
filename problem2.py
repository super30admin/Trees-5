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
        self.first=None
        self.second=None
        self.flag=False
        self.prev=None
        if root==None:
            return None
        def traverse(root):
            if root:
                #find first anomaly
                traverse(root.left)
                if (self.prev!=None and root.val<self.prev.val):
                    if self.flag==False:
                        
                        self.first=self.prev
                        self.second=root
                        self.flag=True
                    else:
                        self.second=root
                self.prev=root
                traverse(root.right)
                
        traverse(root)
        #print(self.first,self.second)
        if self.second==None:
            root.val,self.first.val=self.first.val,root.val
        else:
            self.first.val,self.second.val=self.second.val,self.first.val
        #Time O(n)
        #Space O(n)
                        
