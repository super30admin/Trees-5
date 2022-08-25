"""
Runtime complexity: O(n) -  we traverse all the nodes to recover the BST by performing swaps if parent node is lesser than the child node.
Space Complexity: O(h) - recursive stack space
Space Complexity:
Yes, the code worked on leetcode.
Issues while coding  - No
"""
class Solution:
    def __init__(self):
        self.prev = None
        self.first = None
        self.second = None
    def recoverTree(self, root: Optional[TreeNode]) -> None:
        if not root:
            return root
        self.inorder(root)
        temp =  self.first.val
        self.first.val  = self.second.val
        self.second.val = temp
    
    def inorder(self,root):
        if not root:
            return 
        self.inorder(root.left)
        if self.prev!=None and self.prev.val>=root.val:
            if self.first == None:
                self.first = self.prev
                self.second = root
            else:
                self.second = root
        self.prev = root
        self.inorder(root.right)
    
        
        