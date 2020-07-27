# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    
    
    """
    Name : Shahreen Shahjahan Psyche
    Time : O(N) [Where N is the number of nodes]
    Space: O(H) [Stack Space - Depth of the tree]
           
           
    Passed all Test cases in LC : Yes
    """

    
    def __init__(self):
        self.first = None
        self.last = None
        self.flag = False
        self.prev = None
        
    def helper(self, root):
        
        if not root:
            return
        
        self.helper(root.left)
        
        if self.prev is not None and self.prev.val > root.val:
            if not self.flag:
                self.flag = True
                self.first = self.prev
                self.last = root
            else:
                self.last = root
        
        self.prev = root
        self.helper(root.right)
                
    def recoverTree(self, root: TreeNode) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        
        if(root is None):
            return
        self.helper(root);
        temp = self.last.val;
        self.last.val = self.first.val;
        self.first.val = temp;
    
        
            
        
        
