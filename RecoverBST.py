# TC: O(N) since we are traversing all the nodes exactly once. 
# SC: O(H) where H is the height of the recursive stack to perform inorder traversal. 

class Solution:
    def recoverTree(self, root: TreeNode) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
#         Pointer to store the first breached element
        self.first = None
#         Pointer to store the second element of first breach and second breach
        self.last =  None
#     Flag to indicate if there has been any breach before
        self.flag = False
#     Ponter to traverse the BST and store previous element
        self.prev = None
        
        def inorder(root): 
#             base
            if not root: 
                return
            
            inorder(root.left)
            if self.prev is not None and self.prev.val >= root.val: 
                if not self.flag: 
                    self.first = self.prev
                    self.last = root
                    self.flag = True
                else: 
                    self.last = root
                    flag = False
                
            self.prev = root
            if not self.flag and self.first and self.last: 
                pass
            else: 
                inorder(root.right)
        
        inorder(root)
        temp = self.last.val
        self.last.val = self.first.val
        self.first.val = temp
        
